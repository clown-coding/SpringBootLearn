package com.clown.configfile.test;

import com.clown.configfile.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/12
 * @description: PersonTest
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PersonTest {

    @Autowired
    Person person;

    @Test
    public void personTest(){
        System.out.println(person);
    }
}
