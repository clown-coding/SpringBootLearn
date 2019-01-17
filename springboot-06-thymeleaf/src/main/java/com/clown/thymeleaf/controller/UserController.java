package com.clown.thymeleaf.controller;

import com.clown.thymeleaf.model.User;
import com.clown.thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/16
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        User user = userService.login(username, password);
        if (null == user) {
            map.put("msg","用户名或密码错误!!!");
            return "/login";
        }
        //登陆成功后,防止表单重复提交,可以重定向到主页
        session.setAttribute("loginUser",user.getUsername());
        return "redirect:/main.html";
    }
}
