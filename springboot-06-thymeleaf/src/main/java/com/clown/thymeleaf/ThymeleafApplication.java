package com.clown.thymeleaf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/15
 **/
@MapperScan("com.clown.thymeleaf.mapper")
@SpringBootApplication
public class ThymeleafApplication {
    public static void main(String[] args){
        SpringApplication.run(ThymeleafApplication.class,args);
    }
}
