package com.clown.redis.service;

import com.clown.redis.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Integer id);

    Employee findByLastName(String lastName);

    List<Employee> findByDId(Integer dId);

    String add(Employee employee);

    Employee update(Employee employee);

    String deleteById(Integer id);
}
