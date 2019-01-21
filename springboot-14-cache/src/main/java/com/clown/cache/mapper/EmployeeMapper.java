package com.clown.cache.mapper;

import com.clown.cache.model.Employee;

import java.util.List;

//@Mapper
public interface EmployeeMapper {

    List<Employee> findAll();

    Employee findById(Integer id);

    Employee findByLastName(String lastName);

    List<Employee> findByDId(Integer dId);

    int add(Employee employee);

    int update(Employee employee);

    int deleteById(Integer id);
}
