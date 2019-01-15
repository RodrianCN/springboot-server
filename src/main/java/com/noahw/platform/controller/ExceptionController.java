package com.noahw.platform.controller;

import com.noahw.platform.base.BaseResult;
import com.noahw.platform.constants.ResultConstant;
import com.noahw.platform.exception.UnauthorizedException;
import com.noahw.platform.i18n.LocaleMessage;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**

* @Description:    包含统一异常处理的异常捕捉器

* @Author:         noahw

* @CreateDate:     2019-01-11 9:38

* @Version:        1.0.1

*/
@RestControllerAdvice
public class ExceptionController {

    @Resource
    private LocaleMessage localeMessage;

    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public BaseResult handle401(ShiroException e) {
        return new BaseResult(401, e.getMessage());
    }

    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public BaseResult handle401() {
        return new BaseResult(401, "Unauthorized");
    }

    //捕捉参数校验异常MethodArgumentNotValidException
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult handleBusinessException() {
        return new BaseResult(ResultConstant.RESULTCODE_FAIL, localeMessage.getMessage("para.error"));
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResult globalException() {
        return new BaseResult(ResultConstant.RESULTCODE_FAIL, localeMessage.getMessage("internal.server.error"));
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
