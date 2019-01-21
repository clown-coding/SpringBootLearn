package com.clown.cache.service.impl;

import com.clown.cache.mapper.DepartmentMapper;
import com.clown.cache.model.Department;
import com.clown.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/20
 **/
@CacheConfig(cacheNames = "department",keyGenerator = "myKeyGenerator")//抽取缓存的公共配置
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAll() {
        return departmentMapper.findAll();
    }

    @Cacheable
    @Override
    public Department findById(Integer id) {
        return departmentMapper.findById(id);
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
