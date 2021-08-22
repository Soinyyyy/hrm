package org.soin.dto;

import lombok.Data;
import org.soin.domain.Employee;
import org.soin.domain.Tenant;

/**
 * 封装机构入驻参数对象
 */
@Data
public class TenantRegisterTo {
    private Tenant tenant;
    private Long mealId;
    private Employee employee;
    private String password;
    private String username;

}
