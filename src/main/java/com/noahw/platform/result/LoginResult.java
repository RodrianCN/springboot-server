package com.noahw.platform.result;

import com.noahw.platform.base.BaseResult;

/**

* @Description:    登录Result,包含token

* @Author:         noahw

* @CreateDate:     2019-01-14 10:09

* @Version:        1.0

*/
public class LoginResult extends BaseResult {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResult(String token) {
        this.token = token;
    }
}
