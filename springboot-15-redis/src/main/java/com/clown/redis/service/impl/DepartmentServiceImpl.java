package com.clown.redis.service.impl;

import com.clown.redis.mapper.DepartmentMapper;
import com.clown.redis.model.Department;
import com.clown.redis.service.DepartmentService;
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
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate<String,Department> departmentRedisTemplate;

    @Override
    public List<Department> findAll() {
        List<Department> departmentList = (List<Department>)redisTemplate.opsForValue().get("departmentList");
        if (null == departmentList) {
            synchronized (this){
                departmentList = (List<Department>)redisTemplate.opsForValue().get("departmentList");
                if (null == departmentList) {
                    System.out.println("从数据库查询...");
                    departmentList = departmentMapper.findAll();
                    redisTemplate.opsForValue().set("departmentList",departmentList,60,TimeUnit.SECONDS);
                }
            }
        }
        return departmentList;
    }

    @Override
    public Department findById(Integer id) {
        Department department = departmentRedisTemplate.opsForValue().get("department_" + id);
        if (null == department) {
            synchronized (this){
                department = departmentRedisTemplate.opsForValue().get("department_" + id);
                if (null == department) {
                    department =  departmentMapper.findById(id);
                    departmentRedisTemplate.opsForValue().set("department_"+department.getId(),department,60, TimeUnit.SECONDS);
                }
            }
        }
        return department;
    }

    @Override
    public Department findByDepartmentName(String departmentName) {
        return departmentMapper.findByDepartmentName(departmentName);
    }

    @Override
    public String add(Department department) {
        int row = departmentMapper.add(department);
        if (row <= 0) {
            return "添加失败";
        }
        departmentRedisTemplate.opsForValue().set("department_"+department.getId(),department,60,TimeUnit.SECONDS);
        return "添加成功";
    }

    @Override
    public String update(Department department) {
        int row = departmentMapper.update(department);
        if (row <= 0) {
            return "更新失败";
        }
        return "更新成功";
    }

    @Override
    public String deleteById(Integer id) {
        int row = departmentMapper.deleteById(id);
        if (row <= 0) {
            return "删除失败";
        }
        return "删除成功";
    }
}
