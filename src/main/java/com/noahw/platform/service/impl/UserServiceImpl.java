package com.noahw.platform.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.noahw.platform.exception.BusinessException;
import com.noahw.platform.i18n.LocaleMessage;
import com.noahw.platform.persistence.mapper.UserMapper;
import com.noahw.platform.persistence.pojo.User;
import com.noahw.platform.result.LoginResult;
import com.noahw.platform.service.UserService;
import com.noahw.platform.util.CommonUtil;
import com.noahw.platform.util.JWTUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**

* @Description:    UserServiceImpl

* @Author:         noahw

* @CreateDate:     2019-01-11 9:47

* @Version:        1.0

*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private LocaleMessage localeMessage;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(long id) throws BusinessException {
        try {
            return userMapper.selectById(id);
        }
        catch (Exception e){
            throw new BusinessException();
        }
    }

    @Override
    public User getUserByName(String userName) throws BusinessException {
        try {
            return userMapper.getUserByName(userName);
        }
        catch (Exception e){
            throw new BusinessException();
        }
    }

    @Override
    public void login(String userName, String password, LoginResult result) throws BusinessException {
        try {
            if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
                CommonUtil.updateErrorResult(result, localeMessage.getMessage("para.error"));
                return;
            }
            User user = userMapper.getUserByName(userName);

            if(user == null){
                CommonUtil.updateErrorResult(result, localeMessage.getMessage("user.did.not.exist"));
                return;
            }

            if(!password.equals(user.getPassword())){
                CommonUtil.updateErrorResult(result, localeMessage.getMessage("username.or.password.error"));
                return;
            }

            result.setToken(JWTUtil.sign(userName, password));
        }
        catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BusinessException();
        }
    }
}
