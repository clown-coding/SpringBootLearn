package com.clown.jpa.controller;

import com.clown.jpa.model.Employee;
import com.clown.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/20
 **/
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Integer id){
        return employeeService.findById(id);
    }

    @GetMapping("/findByDId/{dId}")
    public List<Employee> findByDId(@PathVariable("dId") Integer dId){
        return employeeService.findByDId(dId);
    }

    @GetMapping("/findByLastName")
    public Employee findByLastName(@RequestParam("lastName") String lastName){
        return employeeService.findByLastName(lastName);
    }

    @PostMapping
    public String add(@RequestBody Employee employee){
        return employeeService.add(employee);
    }

    @PutMapping
    public String update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        return employeeService.deleteById(id);
    }
}
