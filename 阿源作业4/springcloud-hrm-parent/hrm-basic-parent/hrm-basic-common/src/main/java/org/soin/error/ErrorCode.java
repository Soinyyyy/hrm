package org.soin.error;

/**
 * 自定义错误的状态码
 * 浏览器的规范如200成功
 * 404找不到路径等等
 * 我们也可以自定义状态码返回到前台
 * 使用枚举来定义
 */
public enum ErrorCode{
    TENANT_NAME_NOT_NULL(701,"机构名不能为空"),
    ILLEGAL_CREDIT_CODE(702,"信用码不合法"),
    ILLEGAL_MOBILE_PHONE_NUMBER(703,"手机号不合法"),
    TENANT_IS_EXIST(704,"机构已经注册"),
    ILLEGAL_OPERATION(705,"请不要非法操作");
    /**
     * 错误状态码封装
     * 与错误信息封装
     */
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 调用getmessage的时候获取异常信息并且获取状态码
     * @return
     */
    public String getMessage() {
        return "异常状态码为:"+code+ message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 无参构造函数主要做赋值操作
     * @param code
     * @param message
     */
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
