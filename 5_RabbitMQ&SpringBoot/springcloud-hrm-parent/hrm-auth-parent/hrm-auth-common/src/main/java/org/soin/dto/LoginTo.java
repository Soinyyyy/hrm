package org.soin.dto;

import lombok.Data;

@Data
public class LoginTo {
    private String username;
    private String password;
    /**
     * 0是平台，1是机构  2机构员工
     */
    private Integer type;
}
