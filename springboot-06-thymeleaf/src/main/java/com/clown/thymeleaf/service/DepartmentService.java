package com.clown.thymeleaf.service;

import com.clown.thymeleaf.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAllDepartment();
}
