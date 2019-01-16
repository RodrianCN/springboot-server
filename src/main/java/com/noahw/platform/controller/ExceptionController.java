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
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ShiroException.class)
    public BaseResult handle401(ShiroException e) {
        return initResult(ResultConstant.ACCESS_DENIED);
    }

    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(UnauthorizedException.class)
    public BaseResult handle401() {
        return initResult(ResultConstant.ACCESS_DENIED);
    }

    //捕捉参数校验异常MethodArgumentNotValidException
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult handleBusinessException() {
        return initResult(ResultConstant.PARAM_ERROR);
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResult globalException() {
        return initResult(ResultConstant.INTERNAL_SERVER_ERROR);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

    private BaseResult initResult(ResultConstant constant){
        BaseResult result = new BaseResult();
        result.setResultCode(constant.getResultCode());
        result.setDesc(localeMessage.getMessage(constant.getMessage()));
        return result;
    }
}
