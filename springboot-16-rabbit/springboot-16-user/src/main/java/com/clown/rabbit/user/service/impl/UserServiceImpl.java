package com.clown.rabbit.user.service.impl;

import com.clown.rabbit.user.mapper.IKeyMapper;
import com.clown.rabbit.user.mapper.IUserMapper;
import com.clown.rabbit.user.model.AccessKey;
import com.clown.rabbit.user.model.User;
import com.clown.rabbit.user.service.IUserService;
import com.clown.rabbit.user.utils.IdWorker;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IKeyMapper keyMapper;

    private static final String QUERY = "sms";

    //发送短信验证码
    @Override
    public void sendSms(String mobile) {
        User user = userMapper.findUserByMobile(mobile);
        if(user != null ){
            throw new RuntimeException("该用户手机号已注册");
        }
        //1.生成手机验证码
        Integer code = (int)((Math.random()*9+1)*100000);

        //2.将验证码放入redis缓存中
        redisTemplate.opsForValue().set("smsCode_"+mobile,code,120, TimeUnit.SECONDS);

        //3.查询出AccessKey
        AccessKey accessKey = keyMapper.findById("1087689162657763328").get();

        //4.将用户手机号与验证码,accessKey放入map中
        Map<String,String> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("code",code.toString());
        map.put("accessKeyId",accessKey.getAccessKeyId());
        map.put("accessKeySecret",accessKey.getAccessKeySecret());
        map.put("templateCode",accessKey.getTemplateCode());
        map.put("signName",accessKey.getSignName());

        //4.生产者生产消息
        rabbitTemplate.convertAndSend(QUERY,map);
    }

    @Override
    public void register(String code, User user) {
        //1.获取缓存中存储的验证码
        Object cacheCode = redisTemplate.opsForValue().get("smsCode_" + user.getMobile());

        //2.判断缓存中是否存在该手机好的验证码
        if(cacheCode == null){
            throw new RuntimeException("请先获取验证码");
        }

        //3.比较用户输入的验证码与缓存中的验证码是否一致
        if(!(cacheCode.toString()).equals(code)){
            throw new RuntimeException("验证码错误");
        }

        //4.提取用户密码,对用户密码进行加密
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);

        //5.将用户信息写入到数据库中
        user.setId(String.valueOf(idWorker.nextId()));
        user.setRegdate(new Date());
        user.setUpdatedate(new Date());
        user.setLastdate(new Date());
        userMapper.save(user);
    }

    @Override
    public User login(String mobile, String password) {
        User user = userMapper.findUserByMobile(mobile);
        //判断用户是否存在
        if(user == null){
            throw new RuntimeException("用户名或密码错误");
        }
        //校验用户密码
        boolean flag = passwordEncoder.matches(password,user.getPassword());
        if(!flag){
            throw new RuntimeException("用户名或密码错误");
        }
        return user;
    }
}
