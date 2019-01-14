package com.noahw.platform.security;

import org.apache.shiro.authc.AuthenticationToken;

/**

* @Description:    JWT令牌,已包含Shiro用户信息

* @Author:         noahw

* @CreateDate:     2019-01-11 9:43

* @Version:        1.0

*/
public class JWTToken implements AuthenticationToken {

    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
