package com.clown.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:  Richard·Ackerman
 * @create:  2019/1/10
 **/
@RestController
@RequestMapping("/listen")
public class HelloWorldController {

    @GetMapping("/listen")
    public String listen(){
        return "clown is laughing at you...";
    }
}
