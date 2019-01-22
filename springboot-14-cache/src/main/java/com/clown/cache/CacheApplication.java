package com.clown.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/21
 **/
@EnableCaching
@MapperScan("com.clown.cache.mapper")
@SpringBootApplication
public class CacheApplication {
    public static void main(String[] args){
        SpringApplication.run(CacheApplication.class);
    }
}
