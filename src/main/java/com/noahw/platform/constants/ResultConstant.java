package com.noahw.platform.constants;

/**

* @Description:    Result参数枚举

* @Author:         noahw

* @CreateDate:     2019-01-11 9:38

* @Version:        1.0.1

*/
public enum ResultConstant {

    //服务异常
    INTERNAL_SERVER_ERROR("20000", "internal.server.error"),

    //业务处理成功
    SUCCESS("10000", "success"),

    //token过期或无效(包含未登陆)
    ACCESS_DENIED("30000", "access.denied"),

    //参数错误
    PARAM_ERROR("40001", "param.error"),

    //无操作权限
    PERMISSION_DENIED("30001", "permission.denied"),

    //操作失败
    OPERATE_FAIL("40000", "operation.failed"),

    ;

    public String resultCode;
    public String message;

    ResultConstant(String resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }}
