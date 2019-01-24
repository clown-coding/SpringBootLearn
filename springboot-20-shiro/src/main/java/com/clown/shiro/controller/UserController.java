package com.clown.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: clown
 * @Date: 2019/1/9
 */
@Controller
public class UserController {

    @GetMapping("/listen")
    @ResponseBody
    public String sayHello(){
        return "clown is laughing at you...";
    }


    @GetMapping("/index")
    public String testThymeleaf(Model model){
        model.addAttribute("listen","clown is laughing at you...");
        return "index";
    }

    //前往登录页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login";
    }

    //登录逻辑
    @RequestMapping("/login")
    public String login(String name,String password,Model model){
        /**
         * 使用shiro编写认证操作
         */
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        //3.执行登录方法
        try {
            subject.login(token);
            //登录成功
            return "redirect:/index";
        }catch (UnknownAccountException e) {
            //登录失败:用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
            //登录失败:密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    @RequestMapping("/add")
    public String add(){
        return "/user/add";
    }

    @RequestMapping("/update")
    public String update(){
        return "/user/update";
    }

    @RequestMapping("/noAuth")
    public String noAuth(){
        return "/noAuth";
    }


}
