package com.clown.configfile.test;

import com.clown.configfile.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/12
 * @description: StudentTest
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentTest {

    @Autowired
    Student student;

    @Test
    public void studentTest(){
        System.out.println(student);
    }
}
