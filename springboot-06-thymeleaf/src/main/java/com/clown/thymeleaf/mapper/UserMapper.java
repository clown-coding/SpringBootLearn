package com.clown.thymeleaf.mapper;

import com.clown.thymeleaf.model.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * FROM user WHERE username = #{username}")
    User login(String username);
}
