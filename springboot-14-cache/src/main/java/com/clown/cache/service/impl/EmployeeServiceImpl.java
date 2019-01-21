package com.clown.cache.service.impl;

import com.clown.cache.mapper.EmployeeMapper;
import com.clown.cache.model.Employee;
import com.clown.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/20
 **/
//@CacheConfig(cacheNames = {"employee"})  //其他缓存cacheNames="employee"的就都不用写了
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    //缓存组件名称为employeeList,key = 方法名
    @Cacheable(cacheNames = {"employeeList"},key="#root.methodName")
    @Override
    public List<Employee> findAll() {
        System.out.println("从数据库查询...");
        return employeeMapper.findAll();
    }

    // id > 1 && id != 2 才缓存
    //@Cacheable(value = {"employee"},keyGenerator = "myKeyGenerator",condition = "#id>1", unless = "#id==2")
    @Cacheable(cacheNames = "employee",key = "#id")
    @Override
    public Employee findById(Integer id) {
        System.out.println("从数据库查询...");
        return employeeMapper.findById(id);
    }

    /*
     * 第一次将数据库查询的数据放入缓存
     * cacheName组件名为employee
     * key 则有三个 lastName result.id result.email
     * 如果根据id查询的话,是从缓存中根据id查询数据
     * 如果根据lastName还是会执行SQL语句,因为每一次都会调用@CachePut注解的作用 所以还是会查库
     * 此方法的使用必须与上面的findById()方法的主键生成策略保持一致
     * @CachePut(value = "employee",key = "#result.id")使用的主键是id,上面的findById()方法的主键必须也是id
     * 如果主键策略不一致,无法添加主键是id的缓存数据
     */
    @Caching(
            cacheable = {
                    @Cacheable(value = "employee",key = "#lastName")
            },
            put = {
                    @CachePut(value = "employee",key = "#result.id"),
                    @CachePut(value = "employee",key = "#result.email")
            }
    )
    @Override
    public Employee findByLastName(String lastName) {
        return employeeMapper.findByLastName(lastName);
    }

    //将集合放入缓存,key为自主生成主键策略
    @Cacheable(cacheNames = {"employeeList"},keyGenerator = "myKeyGenerator")
    @Override
    public List<Employee> findByDId(Integer dId) {
        return employeeMapper.findByDId(dId);
    }

    //添加员工后将该员工数据放入缓存中
    @CachePut(cacheNames = {"employee"},key = "#employee.id")
    @Override
    public String add(Employee employee) {
        int row = employeeMapper.add(employee);
        if (row <= 0) {
            return "添加失败";
        }
        return "添加成功";
    }

    //执行方法后,将方法的返回值放入缓存中
    @CachePut(cacheNames = {"employee"},key = "#result.id")
    @Override
    public Employee update(Employee employee) {
        System.out.println("方法执行...");
        int row = employeeMapper.update(employee);
        if (row <= 0) {
            return null;
        }
        return employee;
    }

    //删除员工后将缓存中的所有数据删除(所有),不论方法是否执行成功都删除缓存数据
    @CacheEvict(cacheNames = {"employee"},key = "#id",allEntries = true,beforeInvocation = true)
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
