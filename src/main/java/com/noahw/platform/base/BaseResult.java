package com.noahw.platform.base;

import com.noahw.platform.constants.ResultConstant;

/**

* @Description:    Result父类

* @Author:         noahw

* @CreateDate:     2019-01-11 9:38

* @Version:        1.0

*/
public class BaseResult {
    // http 状态码
    private int resultCode = ResultConstant.RESULTCODE_SUCCESS;

    // 返回信息
    private String desc = ResultConstant.DESC_SUCCESS;

    public BaseResult(int resultCode, String desc) {
        this.resultCode = resultCode;
        this.desc = desc;
    }

    public BaseResult() {

    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
