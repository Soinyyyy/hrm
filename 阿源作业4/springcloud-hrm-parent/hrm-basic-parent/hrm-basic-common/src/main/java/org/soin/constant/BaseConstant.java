package org.soin.constant;

public class BaseConstant {
    /**
     * Redis常量封装
     */
    public class RedisConstant{
        public static final String ALL_COURSE_TYPES = "all_course_types";
    }
    public class LoginConstant{
        // 0是平台，1是机构  2机构员工
        public static final int TYPE_PLATFORM = 0;
        public static final int TYPE_TENANT = 1;
        public static final int TYPE_EMPLOYEE = 2;
    }
    public class EmployeeConstant{
        // 状态：0正常，1锁定，2注销
        public static final int STATE_NORMAL= 0;
        public static final int STATE_DISABLE = 1;
        public static final int STATE_LOGOUT = 2;
        // 员工类型 ， 1平台普通员工 ，2平台客服人员，3平台管理员，4机构员工，5,机构管理员或其他
        public static final int TYPE_PLATFORM_NORMAL = 1;
        public static final int TYPE_PLATFORM_CUSTOMER = 2;
        public static final int TYPE_PLATFORM_ADMIN = 3;
        public static final int TYPE_TENANT_NORMAL = 4;
        public static final int TYPE_TENANT_ADMIN = 5;
    }
    public class TenantConstant{
        // 0待审核，1 审核通过 ， 2审核失败
        public static final int STATE_TO_AUDIT =  0;
        public static final int STATE_AUDIT_PASS = 1;
        public static final int STATE_AUDIT_FAIL = 2;
    }
    public class MealConstant{
        // 状态,是否过期   0 未支付，1已经购买，2过期
        public static final int STATE_TO_PAY=  0;
        public static final int STATE_PAIED = 1;
        public static final int STATE_EXPIRED = 2;
    }
}
