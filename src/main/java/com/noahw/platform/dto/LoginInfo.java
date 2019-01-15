package com.noahw.platform.dto;

import com.noahw.platform.util.JsonUtil;

import javax.validation.constraints.NotBlank;

/**

* @Description:    登录信息json映射

* @Author:         noahw

* @CreateDate:     2019-01-14 17:06

* @Version:        1.0

*/
public class LoginInfo {

    //用户名
    @NotBlank
    private String username;

    //密码
    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return JsonUtil.Object2JsonString(this);
    }
}
