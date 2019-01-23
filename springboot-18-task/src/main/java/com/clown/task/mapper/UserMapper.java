package com.clown.task.mapper;

import com.clown.task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserMapper extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
}
