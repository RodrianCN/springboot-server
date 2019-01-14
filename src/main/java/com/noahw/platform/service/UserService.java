package com.noahw.platform.service;

import com.baomidou.mybatisplus.service.IService;
import com.noahw.platform.exception.BusinessException;
import com.noahw.platform.persistence.pojo.User;
import com.noahw.platform.result.LoginResult;

/**

* @Description:    UserService

* @Author:         noahw

* @CreateDate:     2019-01-11 9:46

* @Version:        1.0

*/
public interface UserService extends IService<User> {

    User getUserById(long id) throws BusinessException;

    User getUserByName(String userName) throws BusinessException;

    void login(String userName, String password, LoginResult result) throws BusinessException;
}
