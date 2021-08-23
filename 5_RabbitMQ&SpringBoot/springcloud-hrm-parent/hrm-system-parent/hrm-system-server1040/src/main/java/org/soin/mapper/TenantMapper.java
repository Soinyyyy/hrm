package org.soin.mapper;

import org.soin.domain.Tenant;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author soin
 * @since 2021-08-15
 */
public interface TenantMapper extends BaseMapper<Tenant> {

    /**
     * 查询数据库判断是否已经入驻
     * @param companyNum
     * @return
     */
    boolean checkTenantExist(String companyNum);
}
