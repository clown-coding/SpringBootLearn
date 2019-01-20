package com.clown.mybatis.mapper;

import com.clown.mybatis.model.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;
//@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM department")
    List<Department> findAll();

    @Select("SELECT * FROM department WHERE id = #{id}")
    Department findById(Integer id);

    @Select("SELECT * FROM department WHERE department_name = #{department_name}")
    Department findByDepartmentName(String departmentName);

    @Options(useGeneratedKeys = true)
    @Insert("INSERT INTO department(department_name) VALUES(#{department_name})")
    int add(Department department);

    @Update("UPDATE department SET department_name = #{department_name} WHERE id = #{id}")
    int update(Department department);

    @Delete("DELETE FROM department WHERE id = #{id}")
    int deleteById(Integer id);


}
