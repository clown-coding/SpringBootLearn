package com.clown.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/18
 **/
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //应用启动
        System.out.println("clown is laughing at you...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //应用销毁
        System.out.println("clown is laughing at you...");
    }
}
