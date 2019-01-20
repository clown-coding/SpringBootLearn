package com.clown.starter.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/21
 *
 * 配置在META-INF/spring.factories
 *
 **/
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    //监听IOC容器的启动
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer...initialize...正在监听IOC容器启动" +applicationContext);
    }
}
