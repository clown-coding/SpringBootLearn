package com.clown.thymeleaf.service.impl;

import com.clown.thymeleaf.mapper.DepartmentMapper;
import com.clown.thymeleaf.model.Department;
import com.clown.thymeleaf.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/15
 **/
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAllDepartment() {
        return departmentMapper.findAllDepartment();
    }
}
