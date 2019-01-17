package com.clown.thymeleaf.controller;

import com.clown.thymeleaf.model.Department;
import com.clown.thymeleaf.model.Employee;
import com.clown.thymeleaf.service.DepartmentService;
import com.clown.thymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/16
 **/
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;


    /**
     * 查询员工列表
     * @return
     */
    @GetMapping("/findAll")
    public String findAll(Model model){
        //查询所有员工
        List<Employee> employeeList = employeeService.findAll();
        //将员工列表放入请求域中
        model.addAttribute("employeeList",employeeList);
        //返回页面视图
        return "employee/list";
    }

    /**
     * 员工添加跳转到添加详情页
     * @return
     */
    @GetMapping("/toAddPage")
    public String toAddPage(Model model){
        //来到添加页面之前查出所有的部门信息
        List<Department> departmentList = departmentService.findAllDepartment();
        model.addAttribute("departmentList",departmentList);
        //返回添加页面
        return "employee/add";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @PostMapping("/add")
    public String add(Employee employee){
        employeeService.add(employee);
        //System.out.println(employee);
        //添加完成后来到员工列表页面
        return "redirect:/employee/findAll";
    }

    /**
     * 根据id查找
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/findById/{id}")
    public String findById(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);
        List<Department> departmentList = departmentService.findAllDepartment();
        model.addAttribute("departmentList",departmentList);
        //修改添加2合一
        return "employee/add";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Employee employee){
        System.out.println(employee);
        employee.setId(id);
        employeeService.update(employee);
        return "redirect:/employee/findAll";
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        if (employeeService.deleteById(id)) {
            return "redirect:/employee/findAll";
        }
        return "redirect:/employee/findAll";
    }


}
