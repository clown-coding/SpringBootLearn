package com.clown.listen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: clown
 * @Date: 2019/1/9
 *
 * @SpringBootApplication: 标注一个主程序类,说明这是一个SpringBoot应用
 */
@SpringBootApplication
public class ListenApplication {
    public static void main(String[] args) {

        // SpringBoot应用启动入口
        SpringApplication.run(ListenApplication.class,args);
    }
}
