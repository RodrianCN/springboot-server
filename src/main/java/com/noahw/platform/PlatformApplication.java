package com.noahw.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**

* @Description:    Springboot工程 启动入口

* @Author:         noahw

* @CreateDate:     2019-01-11 9:48

* @Version:        1.0

*/
@SpringBootApplication
@MapperScan("com.noahw.platform.persistence.mapper")
@EnableCaching
@EnableScheduling
public class PlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);

        System.out.println("启动成功");
    }

}

