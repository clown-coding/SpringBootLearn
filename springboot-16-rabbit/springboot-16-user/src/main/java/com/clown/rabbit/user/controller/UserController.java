package com.clown.rabbit.user.controller;

import com.clown.rabbit.user.model.User;
import com.clown.rabbit.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 发送短信验证码
     * @return
     */
    @PostMapping("/sendSms/{mobile}")
    public String sendSms(@PathVariable("mobile") String mobile){
        try {
            userService.sendSms(mobile);
            return "验证码已发送";
        } catch (Exception e) {
            return "验证码发送失败";
        }

    }

    /**
     * 用户手机号注册
     * @return
     */
    @PostMapping("/register/{code}")
    public String register(@PathVariable("code") String code, @RequestBody User user){
        try {
            userService.register(code,user);
            return "注册成功";
        } catch (Exception e) {
            return "注册失败";
        }

    }

    /**
     * 用户登录
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestBody User user){
        User loginUser = userService.login(user.getMobile(), user.getPassword());
        if (loginUser == null) {
            return "登录失败";
        }
        return "登录成功";
    }
}
