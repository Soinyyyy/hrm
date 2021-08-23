package org.soin.web.controller;

import org.soin.query.LoginLogQuery;
import org.soin.service.ILoginLogService;
import org.soin.domain.LoginLog;
import com.baomidou.mybatisplus.plugins.Page;
import org.soin.util.AjaxResult;
import org.soin.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loginLog")
public class LoginLogController {
    @Autowired
    public ILoginLogService loginLogService;

    /**
    * 保存和修改公用的
    * @param loginLog  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody LoginLog loginLog){
        try {
            if(loginLog.getId()!=null){
                loginLogService.updateById(loginLog);
            }else{
                loginLogService.insert(loginLog);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            loginLogService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public LoginLog get(@PathVariable("id")Long id)
    {
        return loginLogService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<LoginLog> list(){

        return loginLogService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public PageList<LoginLog> json(@RequestBody LoginLogQuery query)
    {
        Page<LoginLog> page = new Page<LoginLog>(query.getPage(),query.getRows());
        page = loginLogService.selectPage(page);
        return new PageList<LoginLog>(page.getTotal(),page.getRecords());
    }
}
