package com.clown.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/15
 **/
@Controller
@RequestMapping("/listen")
public class ListenController {

    @ResponseBody
    @GetMapping
    public String listen(){
        return "clown is laughing at you...";
    }

    /**
     * 查询一些数据在页面显示
     * @return
     */
    @GetMapping("/success")
    public String success(Map<Object,Object> map){
        map.put("listen","<h1>clown is laughing at you...</h1>");
        map.put("userList", Arrays.asList("张3","李4","王5","赵6","田7"));
        return "success/success";
    }
}
