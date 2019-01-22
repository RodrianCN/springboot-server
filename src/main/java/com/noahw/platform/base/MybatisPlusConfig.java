package com.noahw.platform.base;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**

* @Description:    MybatisPlus page相关配置

* @Author:         noahw

* @CreateDate:     2019-01-17 17:36

* @Version:        1.0

*/
@Configuration
public class MybatisPlusConfig {

    /**
        修复Page出现返回total总为0的问题
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}
