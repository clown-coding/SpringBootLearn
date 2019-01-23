package com.clown.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/23
 **/
@EnableAsync            //开启异步任务
@EnableScheduling       //开启定时任务
@SpringBootApplication
public class TaskApplication {
    public static void main(String[] args){
        SpringApplication.run(TaskApplication.class);
    }
}
