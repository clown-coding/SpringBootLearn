package com.clown.configfile.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/12
 * @description: HelloServiceTest
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HelloServiceTest {

    @Autowired
    ApplicationContext applicationContext;



    @Test
    public void helloServiceTest(){
        boolean flag = applicationContext.containsBean("elloService");
        if (flag) {
            System.out.println("存在");
            return;
        }
        System.out.println("不存在");

    }

    @Test
    public void myAppConfigTest(){
        boolean flag = applicationContext.containsBean("helloServiceConfig");
        if (flag) {
            System.out.println("存在");
            return;
        }
        System.out.println("不存在");

    }

    @Test
    public void helloServiceConfigBoot(){
        boolean flag = applicationContext.containsBean("helloServiceConfigBoot");
        if (flag) {
            System.out.println("存在");
            return;
        }
        System.out.println("不存在");

    }
}
