package com.clown.task.service;

import com.clown.task.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    String add(User user);

    void addTask();

    String deleteById(Integer id);

    String simpleMailTask();

    void complexMailTask() throws Exception;

}
