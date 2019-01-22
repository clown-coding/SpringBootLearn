package com.clown.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
 **/
@SpringBootApplication
@MapperScan("com.clown.redis.mapper")
public class RedisApplication {
    public static void main(String[] args){
        SpringApplication.run(RedisApplication.class);
    }
}
