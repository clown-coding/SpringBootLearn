package com.clown.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/24
 **/
@SpringBootApplication
@MapperScan("com.clown.shiro.mapper")
public class ShiroApplication {
    public static void main(String[] args){
        SpringApplication.run(ShiroApplication.class);
    }
}
