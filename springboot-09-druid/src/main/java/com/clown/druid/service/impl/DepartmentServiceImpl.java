package com.clown.druid.service.impl;

import com.clown.druid.mapper.DepartmentMapper;
import com.clown.druid.model.Department;
import com.clown.druid.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/19
 **/
@Service
public class DepartmentServiceImpl implements DepartmentService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Department> findAll() {
        String sql = "SELECT * FROM department";
        List<Department> departmentList = jdbcTemplate.query(sql, new DepartmentMapper());
        return departmentList;
    }

    @Override
    public Department findById(Integer id) {
        Department department = jdbcTemplate.queryForObject("SELECT * FROM department WHERE id = ?", new DepartmentMapper(), id);
        return department;
    }

    @Override
    public String add(Department department) {
        String sql = "INSERT INTO department(departmentName) values(?)";
        int row = jdbcTemplate.update(sql, department.getDepartmentName());
        if (row <= 0) {
            return "添加失败";
        }
        return "添加成功";

    }

    @Override
    public String update(Department department) {
        int row = jdbcTemplate.update("UPDATE department SET departmentName = ? WHERE id =? ", department.getDepartmentName(), department.getId());
        if(row <= 0){
            return "更新失败";
        }
        return "更新成功";
    }

    @Override
    public String delete(Integer id) {
        int row = jdbcTemplate.update("DELETE FROM department WHERE id = ?", id);
        if(row <= 0){
            return "删除失败";
        }
        return "删除成功";
    }
}
