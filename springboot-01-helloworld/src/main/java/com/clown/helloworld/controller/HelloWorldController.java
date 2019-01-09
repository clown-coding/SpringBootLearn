package com.clown.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: clown
 * @Date: 2019/1/9
 */
@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

    @GetMapping("/say")
    public String say(){
        return "clown is laughing at you...";
    }
}
