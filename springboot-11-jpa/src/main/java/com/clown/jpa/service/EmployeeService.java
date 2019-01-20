package com.clown.jpa.service;

import com.clown.jpa.model.Employee;

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
