package com.clown.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/20
 **/
@MapperScan("com.clown.mybatis.mapper")
@SpringBootApplication
public class MyBatisApplication {
    public static void main(String[] args){
        SpringApplication.run(MyBatisApplication.class);
    }
}
