package com.clown.cache.controller;

import com.clown.cache.model.Department;
import com.clown.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/20
 **/
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> findAll(){
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Integer id){
        return departmentService.findById(id);
    }

    @GetMapping("/findByDepartmentName/{departmentName}")
    public Department findByDepartmentName(@PathVariable("departmentName") String departmentName){
        return departmentService.findByDepartmentName(departmentName);
    }

    @PostMapping
    public String add(@RequestBody Department department){
        return departmentService.add(department);
    }

    @PutMapping
    public String update(@RequestBody Department department){
        return  departmentService.update(department);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        return departmentService.deleteById(id);
    }
}
