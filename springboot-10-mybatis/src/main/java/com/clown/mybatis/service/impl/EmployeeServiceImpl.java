package com.clown.mybatis.service.impl;

import com.clown.mybatis.mapper.EmployeeMapper;
import com.clown.mybatis.model.Employee;
import com.clown.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/20
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll() {
        return employeeMapper.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeMapper.findById(id);
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
        return "添加成功";
    }

    @Override
    public String update(Employee employee) {
        int row = employeeMapper.update(employee);
        if (row <= 0) {
            return "更新失败";
        }
        return "更新成功";
    }

    @Override
    public String deletById(Integer id) {
        int row = employeeMapper.deletById(id);
        if (row <= 0) {
            return "删除失败";
        }
        return "删除成功";
    }
}
