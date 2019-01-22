package com.clown.rabbit.user.service;

import com.clown.rabbit.user.model.User;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
 **/
public interface IUserService {

    //发送短信验证码
    void sendSms(String mobile);

    //用户手机号注册
    void register(String code, User user);

    //用户登录
    User login(String mobile,String password);
}
