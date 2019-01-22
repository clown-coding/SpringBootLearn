package com.clown.redis.service;

import com.clown.redis.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Integer id);

    String add(User user);

    String update(User user);

    String deleteById(Integer id);
}
