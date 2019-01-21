package com.clown.custom.starter.controller;

import com.clown.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/21
 **/
@RestController
public class ListenController {

    @Autowired
    HelloService helloService;

    @GetMapping("/listen")
    public String  hello(){
        return helloService.sayHelloClown("say");
    }
}
