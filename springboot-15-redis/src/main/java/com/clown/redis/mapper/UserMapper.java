package com.clown.redis.mapper;

import com.clown.redis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
 **/
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> findAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert("INSERT INTO user(username,password) VALUES(#{username},#{password})")
    int add(User user);

    @Update("UPDATE user SET username=#{username},password=#{password} WHERE id = #{id}")
    int update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    int deleteById(Integer id);
}
