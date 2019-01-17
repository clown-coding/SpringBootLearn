package com.clown.thymeleaf.service.impl;

import com.clown.thymeleaf.mapper.UserMapper;
import com.clown.thymeleaf.model.User;
import com.clown.thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/16
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        User user = userMapper.login(username);
        if (null == user) {
            return null;
        }
        boolean flag = user.getPassword().equals(password);
        if (!flag) {
            return null;
        }
        return user;
    }
}
