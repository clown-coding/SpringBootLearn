package com.clown.task.controller;

import com.clown.task.model.User;
import com.clown.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/23
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public String add(@RequestBody User user){
        return userService.add(user);
    }

    @DeleteMapping("/{id}")
    public String add(@PathVariable("id") Integer id){
        return userService.deleteById(id);
    }

    @GetMapping("/mail")
    public String simpleMailTask(){
        return userService.simpleMailTask();
    }

}
