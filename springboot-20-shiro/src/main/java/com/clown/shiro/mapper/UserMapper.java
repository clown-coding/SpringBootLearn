package com.clown.shiro.mapper;

import com.clown.shiro.model.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * FROM user WHERE name=#{name}")
    User findByName(String name);

    @Select("SELECT * FROM user WHERE id=#{id}")
    User findById(Integer id);

}
