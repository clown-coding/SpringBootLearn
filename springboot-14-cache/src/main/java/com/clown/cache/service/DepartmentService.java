package com.clown.cache.service;

import com.clown.cache.model.Department;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/20
 **/
public interface DepartmentService {

    List<Department> findAll();

    Department findById(Integer id);

    Department findByDepartmentName(String departmentName);

    String add(Department department);

    String update(Department department);

    String deleteById(Integer id);
}
