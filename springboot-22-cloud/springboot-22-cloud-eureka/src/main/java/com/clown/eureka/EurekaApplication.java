package com.clown.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/24
 **/
//服务注册中心
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args){
        SpringApplication.run(EurekaApplication.class);
    }
}
