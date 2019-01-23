package com.clown.task.service.impl;

import com.clown.task.mapper.UserMapper;
import com.clown.task.model.User;
import com.clown.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.Random;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/23
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Async
    @Override
    public String add(User user) {
        try {
            Thread.sleep(3000);
            userMapper.save(user);
            return "添加成功";
        } catch (InterruptedException e) {
            return "添加失败";
        }
    }

    //每隔一分钟添加一条数据
    @Scheduled(cron = "0 * * * * MON-SAT")
    @Override
    public void addTask(){
        User user = new User();
        user.setId(new Random().nextInt());
        user.setUsername("王"+new Random().nextInt());
        user.setPassword(String.valueOf(new Random().nextInt()));
        userMapper.save(user);
    }

    @Override
    public String deleteById(Integer id) {
        try {
            userMapper.deleteById(id);
            return "删除成功";
        } catch (Exception e) {
            return "删除失败";
        }
    }

    @Override
    public String simpleMailTask() {
        //创建一个简单的消息邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //邮件设置
        simpleMailMessage.setFrom("clown_coding@163.com");
        simpleMailMessage.setSubject("通知");
        simpleMailMessage.setText("今晚加班!!!");
        simpleMailMessage.setTo("1422469024@qq.com");
        //发送
        try {
            javaMailSender.send(simpleMailMessage);
            return "发送成功";
        } catch (MailException e) {
            return "发送失败";
        }
    }

    //每5分钟发送一条邮件
    @Scheduled(cron = "0 0/2 * * * MON-SAT")
    @Override
    public void complexMailTask()throws Exception {
        //创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        //邮件设置
        mimeMessageHelper.setFrom("clown_coding@163.com");
        mimeMessageHelper.setSubject("通知");
        mimeMessageHelper.setText("<b style = 'color:red'> 今天加班 </b>",true);
        mimeMessageHelper.setTo("1422469024@qq.com");

        //上传附件
        mimeMessageHelper.addAttachment("joker.png",new File("springboot-18-task/doc/images/1.jpg"));
        mimeMessageHelper.addAttachment("哈莉奎茵.png",new File("springboot-18-task/doc/images/2.jpg"));

        //发送
        javaMailSender.send(mimeMessage);
        System.out.println("邮件发送...");
    }

}
