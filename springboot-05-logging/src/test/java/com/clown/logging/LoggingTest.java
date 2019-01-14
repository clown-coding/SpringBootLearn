package com.clown.logging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/14
 * @description: 日志测试类
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoggingTest {

    @Test
    public void loggingTest(){
        //日志记录器
        Logger logger = LoggerFactory.getLogger(getClass());

        //日志级别 低-->高  trace<debug<info<warn<error
        //调整级别,设置一个级别,只会打印这个级别到高级别的信息
        //springboot默认使用info级别
        logger.trace("这是trace信息");
        logger.debug("这是debug信息");
        logger.info("这是info信息");
        logger.warn("这是warn信息");
        logger.error("这是error信息");
    }
}
