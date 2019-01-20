package com.clown.starter.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/21
 *
 * 配置在META-INF/spring.factories
 *
 **/
public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {

    //构造器
    public HelloSpringApplicationRunListener(SpringApplication application, String[] args){}

    //容器正在启动
    @Override
    public void starting() {
        System.out.println("SpringApplicationRunListener...starting...容器正在启动");
    }

    //IOC环境准备好了
    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("SpringApplicationRunListener...environmentPrepared...IOC环境准备好了");
        //环境信息中获取系统属性
        Object systemName = environment.getSystemEnvironment();
        List<Object> list = Arrays.asList(systemName);
        list.stream().forEach(System.out::println);

    }

    //IOC容器准备好了
    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...contextPrepared...IOC容器准备好了");
    }

    //IOC容器环境加载完成
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...contextLoaded...IOC容器环境加载完成");
    }

    //IOC容器已经开始运行
    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...started...IOC容器已经开始运行");
    }

    //IOC容器正在运行中
    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...running...IOC容器正在运行中");
    }

    //IOC容器启动失败
    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("SpringApplicationRunListener...failed...IOC容器启动失败");
    }
}
