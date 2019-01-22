package com.clown.redis;

import com.clown.redis.model.Department;
import com.clown.redis.service.DepartmentService;
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
public class DepartmentTest {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RedisTemplate<String, Department> departmentRedisTemplate;

    @Test
    public void departmentSet(){
        Department department = departmentService.findById(1);
        departmentRedisTemplate.opsForValue().set("department_"+department.getId(),department,60, TimeUnit.SECONDS);
    }

    @Test
    public void departmentGet(){
        Department department = departmentRedisTemplate.opsForValue().get("department_1");
        System.out.println(department);
    }

}
