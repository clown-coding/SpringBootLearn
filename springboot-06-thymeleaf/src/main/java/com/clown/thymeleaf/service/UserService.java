package com.clown.thymeleaf.service;

import com.clown.thymeleaf.model.User;

public interface UserService {
    User login(String username,String password);
}
