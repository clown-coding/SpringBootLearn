package com.clown.mybatis.service;

import com.clown.mybatis.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Integer id);

    Employee findByLastName(String lastName);

    List<Employee> findByDId(Integer dId);

    String add(Employee employee);

    String update(Employee employee);

    String deleteById(Integer id);
}
