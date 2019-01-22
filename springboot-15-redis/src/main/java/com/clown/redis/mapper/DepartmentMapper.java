package com.clown.redis.mapper;

import com.clown.redis.model.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM department")
    List<Department> findAll();

    @Select("SELECT * FROM department WHERE id = #{id}")
    Department findById(Integer id);

    @Select("SELECT * FROM department WHERE department_name = #{departmentName}")
    Department findByDepartmentName(String departmentName);

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("INSERT INTO department(department_name) VALUES(#{departmentName})")
    int add(Department department);

    @Update("UPDATE department SET department_name = #{departmentName} WHERE id = #{id}")
    int update(Department department);

    @Delete("DELETE FROM department WHERE id = #{id}")
    int deleteById(Integer id);


}
