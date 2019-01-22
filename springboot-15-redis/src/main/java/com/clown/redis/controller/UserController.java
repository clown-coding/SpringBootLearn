package com.clown.redis.controller;

import com.clown.redis.model.User;
import com.clown.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
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

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Integer id){
       return userService.findById(id);
    }

    @PostMapping
    public String add(@RequestBody User user){
        return userService.add(user);
    }

    @PutMapping
    public String update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        return userService.deleteById(id);
    }
}
