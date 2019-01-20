package com.clown.mybatis.service.impl;

import com.clown.mybatis.mapper.DepartmentMapper;
import com.clown.mybatis.model.Department;
import com.clown.mybatis.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/20
 **/
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAll() {
        return departmentMapper.findAll();
    }

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
