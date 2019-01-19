package com.clown.jdbc.mapper;

import com.clown.jdbc.model.Department;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/19
 **/
public class DepartmentMapper implements RowMapper<Department> {
    @Override
    public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String departmentName = rs.getString("departmentName");
        Department department = new Department(id,departmentName);
        return department;
    }
}
