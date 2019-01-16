package com.noahw.platform.base;

/**

* @Description:    Result父类

* @Author:         noahw

* @CreateDate:     2019-01-11 9:38

* @Version:        1.0

*/
public class BaseResult {

    // 返回状态码
    private String resultCode = "10000";

    // 返回信息
    private String desc = "操作成功";

    public BaseResult(String resultCode, String desc) {
        this.resultCode = resultCode;
        this.desc = desc;
    }

    public BaseResult(){

    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
