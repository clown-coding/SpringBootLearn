package com.clown.thymeleaf.service.impl;

import com.clown.thymeleaf.mapper.DepartmentMapper;
import com.clown.thymeleaf.mapper.EmployeeMapper;
import com.clown.thymeleaf.model.Department;
import com.clown.thymeleaf.model.Employee;
import com.clown.thymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/15
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = employeeMapper.findAll();
        for (Employee employee : employeeList) {
            Department department = departmentMapper.findById(employee.getDepartmentid());
            employee.setDepartment(department);
        }
        return employeeList;
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = employeeMapper.findById(id);
        Department department = departmentMapper.findById(employee.getDepartmentid());
        employee.setDepartment(department);
        return employee;
    }

    /**
     * 添加
     * @param employee
     */
    @Override
    public void add(Employee employee) {
        employeeMapper.add(employee);
    }

    /**
     * 修改
     * @param employee
     */
    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public boolean deleteById(Integer id) {
        if (1 != employeeMapper.deleteById(id)) {
            return false;
        }
        return true;
    }
}
