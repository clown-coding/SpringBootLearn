package com.clown.redis;

import com.clown.redis.model.Employee;
import com.clown.redis.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RedisTemplate<Object,Employee> employeeRedisTemplate;

    //redis默认是使用JDK的序列化保存数据
    @Test
    public void employeeSet(){
        Employee employee = employeeService.findById(1);
        employeeRedisTemplate.opsForValue().set("employee_"+employee.getId(),employee,60, TimeUnit.SECONDS);
    }

    @Test
    public void employeeGet(){
        Employee employee = employeeRedisTemplate.opsForValue().get("employee_1");
        System.out.println(employee);
    }
}
