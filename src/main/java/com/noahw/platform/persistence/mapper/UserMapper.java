package com.noahw.platform.persistence.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.noahw.platform.persistence.pojo.User;
import org.apache.ibatis.annotations.Param;

/**

* @Description:    用户类Dao

* @Author:         noahw

* @CreateDate:     2019-01-11 9:40

* @Version:        1.0

*/
public interface UserMapper extends BaseMapper<User> {

    User getUserByName(@Param("userName") String userName);
}
