package com.clown.jdbc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/19
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JdbcTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void dataSourceTest(){
        System.out.println(dataSource.getClass());
    }
}
