package com.clown.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/24
 **/
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/listen")
    public String listen(){
        return restTemplate.getForObject("http://provider/listen",String.class);
    }
}
