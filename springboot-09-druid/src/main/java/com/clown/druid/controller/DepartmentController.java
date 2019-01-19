package com.clown.druid.controller;

import com.clown.druid.model.Department;
import com.clown.druid.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/19
 **/
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/findAll")
    public List<Department> findAll(){
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Integer id){
        Department department = departmentService.findById(id);
        return department;
    }

    @PostMapping("/add")
    public String add(@RequestBody Department department){
        return departmentService.add(department);
    }

    @PutMapping("/update")
    public String update(@RequestBody Department department){
        return departmentService.update(department);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id){
        return departmentService.delete(id);
    }
}
