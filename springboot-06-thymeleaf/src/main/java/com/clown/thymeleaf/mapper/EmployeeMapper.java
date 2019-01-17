package com.clown.thymeleaf.mapper;

import com.clown.thymeleaf.model.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmployeeMapper {

    @Select("SELECT * FROM employee")
    List<Employee> findAll();

    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee findById(Integer id);

    @Insert(" INSERT INTO employee (lastName,email,gender,departmentid,birth) VALUES(#{lastName},#{email},#{gender},#{departmentid},#{birth})")
    void add(Employee employee);

    @Update("UPDATE employee set lastName=#{lastName},email=#{email},gender=#{gender},departmentid=#{departmentid},birth=#{birth} WHERE id = #{id}")
    void update(Employee employee);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    int deleteById(Integer id);
}
