package com.clown.configfile.test;

import com.clown.configfile.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/12
 * @description: CarTest
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CarTest {

    @Autowired
    Car car;

    @Test
    public void carTest(){
        System.out.println(car);
    }
}
