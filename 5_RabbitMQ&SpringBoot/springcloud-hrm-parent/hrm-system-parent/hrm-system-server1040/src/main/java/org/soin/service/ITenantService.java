package org.soin.service;

import org.soin.domain.Tenant;
import com.baomidou.mybatisplus.service.IService;
import org.soin.dto.TenantRegisterTo;

/**
 * <p>
 *  服务类
 * </p>
 * 机构入驻
 * @author soin
 * @since 2021-08-15
 */
public interface ITenantService extends IService<Tenant> {

    void insertMeal(TenantRegisterTo to);
}
