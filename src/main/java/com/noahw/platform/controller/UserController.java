package com.noahw.platform.controller;

import com.alibaba.fastjson.JSONObject;
import com.noahw.platform.exception.BusinessException;
import com.noahw.platform.persistence.pojo.User;
import com.noahw.platform.result.DataReturnResult;
import com.noahw.platform.result.LoginResult;
import com.noahw.platform.service.UserService;
import com.noahw.platform.util.JsonUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**

* @Description:    用户相关Controller

* @Author:         noahw

* @CreateDate:     2019-01-11 9:37

* @Version:        1.0

*/
@RestController
@RequestMapping("/start")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/user/id/{id}")
    @RequiresAuthentication
    public DataReturnResult getUserInfoById(@PathVariable("id") Long id) throws BusinessException{
        User user = userService.getUserById(id);
        logger.info("getUserInfoById --- userInfo:{}", JsonUtil.Object2JsonString(user));
        return new DataReturnResult(user);
    }

    @GetMapping("/user/name/{name}")
    @RequiresAuthentication
    public DataReturnResult getUserInfoByName(@PathVariable("name") String name) throws BusinessException{
        User user = userService.getUserByName(name);
        logger.info("getUserInfoByName --- userInfo:{}", JsonUtil.Object2JsonString(user));
        return new DataReturnResult(user);
    }

    @PostMapping("/login")
    public LoginResult login(@RequestBody JSONObject requestJson) throws BusinessException {
        LoginResult result = new LoginResult(null);
        userService.login(requestJson.getString("username"), requestJson.getString("password"), result);
        return result;
    }
}
