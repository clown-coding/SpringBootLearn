package com.clown.starter.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/21
 *
 * 在IOC容器中的
 *
 **/
@Component
public class HelloCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner...run==="+ Arrays.asList(args));
    }
}
