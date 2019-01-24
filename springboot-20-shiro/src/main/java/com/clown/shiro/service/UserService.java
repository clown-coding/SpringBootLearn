package com.clown.shiro.service;

import com.clown.shiro.model.User;

public interface UserService {

    User findByName(String name);

    User findById(Integer id);
 }
