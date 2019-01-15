package com.noahw.platform.base;

import com.noahw.platform.util.JsonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**

* @Description:    增加Controller切点日志用于监控接口入/出参数

* @Author:         noahw

* @CreateDate:     2019-01-15 9:37

* @Version:        1.0

*/
@Aspect
@Component
public class ParamLogger {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //申明一个切点 里面是 execution表达式
    @Pointcut("execution(public * com.noahw.platform.controller.*.*(..))")
    private void controllerAspect(){}


    //请求method前打印内容
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        String controllerMethod = joinPoint.getSignature().toString();

        //打印请求内容
        logger.info("===============请求内容===============");
        logger.info("请求IP:{}", request.getRemoteAddr());
        logger.info("请求地址:{}", request.getRequestURL().toString());
        logger.info("请求方式:{}", request.getMethod());

        //用户登陆接口,不打印Authorization信息
        if (!controllerMethod.contains("UserController.login")){
            logger.info("请求消息头Authorization:{}", request.getHeader("Authorization"));
        }

        logger.info("请求类方法:{}", controllerMethod);
        logger.info("请求类方法参数:{}", Arrays.toString(joinPoint.getArgs()));
        logger.info("===============请求内容===============");
    }


    //在方法执行完结后打印返回内容
    @AfterReturning(returning = "o",pointcut = "controllerAspect()")
    public void methodAfterReturn(Object o){
        logger.info("===============返回内容===============");
        logger.info("Response内容:{}", JsonUtil.Object2JsonString(o));
        logger.info("===============返回内容===============");
    }
}
