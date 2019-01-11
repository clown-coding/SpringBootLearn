package com.clown.listen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:  Richard·Ackerman
 * @create:  2019/1/10
 **/

@RestController
@RequestMapping("/listen")
public class ListenController {

    @GetMapping("/listen")
    public String listen(){

        //返回JSON字符串
        return "clown is laughing at you...";
    }
}
