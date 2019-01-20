package com.clown.jpa.service.impl;

import com.clown.jpa.mapper.EmployeeMapper;
import com.clown.jpa.model.Employee;
import com.clown.jpa.service.EmployeeService;
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
        return employeeMapper.findById(id).get();
    }

    @Override
    public Employee findByLastName(String lastName) {
        return employeeMapper.findEmployeeByLastName(lastName);
    }

    @Override
    public List<Employee> findByDId(Integer dId) {
        return employeeMapper.findEmployeeByDId(dId);
    }

    @Override
    public String add(Employee employee) {
        Employee save = employeeMapper.save(employee);
        if(null == save){
            return "添加失败";
        }
        return "添加成功";
    }

    @Override
    public String update(Employee employee) {
        Employee update = employeeMapper.save(employee);
        if(null == update){
            return "更新失败";
        }
        return "更新成功";
    }

    @Override
    public String deleteById(Integer id) {
        try {
            employeeMapper.deleteById(id);
            return "删除成功";
        } catch (Exception e) {
            return "删除失败";
        }
    }
}
