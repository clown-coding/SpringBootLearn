package com.clown.redis.service.impl;

import com.clown.redis.mapper.EmployeeMapper;
import com.clown.redis.model.Employee;
import com.clown.redis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/20
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate<Object,Employee> employeeRedisTemplate;


    //使用双重检测锁防止缓存穿透
    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = (List<Employee>)redisTemplate.opsForValue().get("employeeList");
        if (null == employeeList) {
            synchronized (this){
                employeeList = (List<Employee>)redisTemplate.opsForValue().get("employeeList");
                if (null == employeeList){
                    System.out.println("从数据库查询...");
                    employeeList = employeeMapper.findAll();
                    redisTemplate.opsForValue().set("employeeList",employeeList,60, TimeUnit.SECONDS);
                }
            }
        }
        return employeeList;
    }

    //使用双重检测锁防止缓存穿透
    @Override
    public Employee findById(Integer id) {
        Employee employee = employeeRedisTemplate.opsForValue().get("employee_" + id);
        if(null == employee){
            synchronized (this){
                employee = employeeRedisTemplate.opsForValue().get("employee_" + id);
                if (null == employee) {
                    System.out.println("从数据库查询...");
                    employee = employeeMapper.findById(id);
                    employeeRedisTemplate.opsForValue().set("employee_"+id,employee,60,TimeUnit.SECONDS);
                }
            }
        }
        return employee;
    }


    @Override
    public Employee findByLastName(String lastName) {
        return employeeMapper.findByLastName(lastName);
    }


    @Override
    public List<Employee> findByDId(Integer dId) {
        return employeeMapper.findByDId(dId);
    }


    @Override
    public String add(Employee employee) {
        int row = employeeMapper.add(employee);
        if (row <= 0) {
            return "添加失败";
        }
        employeeRedisTemplate.opsForValue().set("employee_"+employee.getId(),employee,60,TimeUnit.SECONDS);
        return "添加成功";
    }


    @Override
    public Employee update(Employee employee) {
        System.out.println("方法执行...");
        int row = employeeMapper.update(employee);
        if (row <= 0) {
            return null;
        }
        return employee;
    }


    @Override
    public String deleteById(Integer id) {
        return "删除成功";
//        int row = employeeMapper.deleteById(id);
//        if (row <= 0) {
//            return "删除失败";
//        }
//        return "删除成功";
    }
}
