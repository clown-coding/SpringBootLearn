package com.clown.configfile.config;

import com.clown.configfile.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/12
 * @description: 配置类
 *
 * @Configuration: 指明当前类是一个配置类,就是替代之前的beans.xml文件
 **/
@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中,默认id就是方法名
    @Bean
    public HelloService helloServiceConfig(){
        return new HelloService();
    }
}
