package com.clown.provider.controller;

import com.clown.provider.service.ListenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/24
 **/
@RestController
public class ListenController {

    @Autowired
    private ListenService listenService;

    @GetMapping("/listen")
    public String listen(){
        return listenService.listen();
    }
}
