package com.clown.starter.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/21
 *
 * 在IOC容器中的
 *
 **/
@Component
public class HelloApplicationRunner implements ApplicationRunner {

    //args: 命令行参数,打印看是什么时候调用的
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner...run==="+args);
    }
}
