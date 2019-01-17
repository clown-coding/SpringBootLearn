package com.clown.thymeleaf.service;

import com.clown.thymeleaf.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Integer id);

    void add(Employee employee);

    void update(Employee employee);

    boolean deleteById(Integer id);
}
