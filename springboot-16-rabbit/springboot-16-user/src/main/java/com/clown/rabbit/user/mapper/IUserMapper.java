package com.clown.rabbit.user.mapper;

import com.clown.rabbit.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
 **/
public interface IUserMapper extends JpaRepository<User,String> , JpaSpecificationExecutor<User> {

    //通过用户手机号查询用户
    User findUserByMobile(String mobile);
}
