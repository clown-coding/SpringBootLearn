package com.clown.jdbc.service;

import com.clown.jdbc.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAll();

    Department findById(Integer id);

    String add(Department department);

    String update(Department department);

    String delete(Integer id);


}
