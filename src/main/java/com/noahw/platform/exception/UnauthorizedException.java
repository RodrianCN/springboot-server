package com.noahw.platform.exception;

/**

* @Description:    JWT验证异常

* @Author:         noahw

* @CreateDate:     2019-01-11 9:40

* @Version:        1.0

*/
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}
