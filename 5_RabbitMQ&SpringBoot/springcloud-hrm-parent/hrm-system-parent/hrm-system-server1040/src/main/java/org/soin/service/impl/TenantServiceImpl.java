package org.soin.service.impl;

import org.apache.commons.lang.time.DateUtils;
import org.soin.constant.BaseConstant;
import org.soin.domain.Employee;
import org.soin.domain.Tenant;
import org.soin.error.ErrorCode;
import org.soin.feign.LoginFeignClient;
import org.soin.mapper.EmployeeMapper;
import org.soin.mapper.TenantMapper;
import org.soin.service.ITenantService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.soin.dto.LoginMealTo;
import org.soin.dto.LoginTo;
import org.soin.dto.TenantRegisterTo;
import org.soin.util.AjaxResult;
import org.soin.util.AssertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 * @author soin
 * @since 2021-08-15
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {
    //使用FeignClient来解决微服务相互调用的问题
    @Autowired
    private LoginFeignClient loginFeignClient;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private TenantMapper tenantMapper;
    /**
     * yml配置文件读取方式
     */
    @Value("${expire.days}")
    private int days;

    @Override
    public void insertMeal(TenantRegisterTo to) {
        //1.获取参数然后校验
        Tenant tenant = to.getTenant();
        Employee employee = to.getEmployee();
        Long mealId = to.getMealId();
        String password = to.getPassword();
        //2.调用校验方法来校验参数是否合理
        checkParam(tenant,employee);
        //3.微服务之间如果相互调用会存在问题这里使用feign来完成调用
        //3.1保存login
        //3.2获取登录对象
        LoginTo login = new LoginTo();
        login.setUsername(to.getUsername());
        //赋值登录状态为1默认是可用
        login.setType(BaseConstant.LoginConstant.TYPE_TENANT);
        //调用feign来保存登录信息
        AjaxResult result = loginFeignClient.save(login);
        //校验结果集
        AssertUtils.isNull(result.getResultObj(), ErrorCode.ILLEGAL_OPERATION.getMessage());
        Long loginId = Long.valueOf(result.getResultObj().toString());
        /**
         * 保存员工
         */
        //赋值员工名字
        employee.setRealName(to.getUsername());
        //赋值当前时间
        employee.setInputTime(new Date());
        //设置当前机构状态要
        employee.setState(BaseConstant.EmployeeConstant.STATE_NORMAL);
        employee.setLoginId(loginId);
        employee.setType(BaseConstant.EmployeeConstant.TYPE_TENANT_ADMIN);
        //上面都是在对当前的机构进行赋值现在我们直接调用保存方法对这些数据进行保存即可
        employeeMapper.insert(employee);
        /**
         * 保存机构
         */
        //当前机构入驻的人就是管理员
        tenant.setAdminId(employee.getId());
        //当前入驻的时间
        tenant.setRegisterTime(new Date());
        //设置入驻时候的状态是什么
        tenant.setState(BaseConstant.TenantConstant.STATE_TO_AUDIT);
        super.insert(tenant);
        //获取当前机构的id
        employee.setTenantId(tenant.getId());
        //修改原来employye表里面的tenantid
        employeeMapper.updateById(employee);
        /**
         * 套餐保存
         */
        //获取套餐对象
        LoginMealTo loginMealTo = new LoginMealTo();
        loginMealTo.setLoginId(loginId);
        loginMealTo.setMealId(mealId);
        //套餐试用期为7天
        loginMealTo.setExpireDate(DateUtils.addDays(new Date(),days));
        //保存的当前状态
        loginMealTo.setState(BaseConstant.MealConstant.STATE_TO_PAY);
        //调用feign来保存
        loginFeignClient.saveLoginMeal(loginMealTo);
    }
    /**
     * 一些参数校验
     * 手机号合法性
     * 机构信用码合法性校验
     * @param tenant
     * @param employee
     */
    private void checkParam(Tenant tenant, Employee employee) {
        /**
         * 机构名称判断
         */
        AssertUtils.isNull(tenant.getCompanyName(),ErrorCode.TENANT_NAME_NOT_NULL.getMessage());
        /**
         * 机构信用码判断
         */
        AssertUtils.isNotLicense(tenant.getCompanyNum(),ErrorCode.ILLEGAL_CREDIT_CODE.getMessage());
        /**
         * 手机号合法性判断
         */
        AssertUtils.isNotMobile(employee.getTel(),ErrorCode.ILLEGAL_MOBILE_PHONE_NUMBER.getMessage());
        /**
         * 机构是否存在判断
         */
        AssertUtils.isTrue(tenantMapper.checkTenantExist(tenant.getCompanyNum()),ErrorCode.TENANT_IS_EXIST.getMessage() );
    }
}
