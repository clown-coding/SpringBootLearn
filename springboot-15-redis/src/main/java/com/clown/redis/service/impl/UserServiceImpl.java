package com.clown.redis.service.impl;

import com.clown.redis.mapper.UserMapper;
import com.clown.redis.model.User;
import com.clown.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<Object,User> userRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CacheManager userRedisCacheManager;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(Integer id) {
        User user = userRedisTemplate.opsForValue().get("user_" + id);
        if (null == user) {
            System.out.println("从数据库查询...");
            user = userMapper.findById(id);
            userRedisTemplate.opsForValue().set("user_"+user.getId(),user,60, TimeUnit.SECONDS);
        }
        return user;
    }

    @Override
    public String add(User user) {
        int row = userMapper.add(user);
        if (row <= 0) {
            return "添加失败";
        }
        Cache cache = userRedisCacheManager.getCache("user");
        cache.put("user_"+user.getId(),user);
        return "添加成功";
    }

    @Override
    public String update(User user) {
        int row = userMapper.update(user);
        if (row <= 0) {
            return "更新失败";
        }
        return "更新成功";
    }

    @Override
    public String deleteById(Integer id) {
        int row = userMapper.deleteById(id);
        if (row <= 0) {
            return "删除失败";
        }
        return "删除成功";
    }
}
