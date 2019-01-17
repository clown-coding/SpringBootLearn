package com.clown.thymeleaf.mapper;

import com.clown.thymeleaf.model.Department;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepartmentMapper {

    @Select("SELECT * FROM department")
    List<Department> findAllDepartment();

    @Select("SELECT * FROM department WHERE id = #{id}")
    Department findById(Integer id);
}
