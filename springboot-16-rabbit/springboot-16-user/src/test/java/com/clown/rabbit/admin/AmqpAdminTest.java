package com.clown.rabbit.admin;

import com.clown.rabbit.user.UserApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class AmqpAdminTest {

    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * 创建交换器
     */
    @Test
    public void creatExchange(){
        DirectExchange exchange = new DirectExchange("admin.exchange");
        amqpAdmin.declareExchange(exchange);
        System.out.println("创建完成");
    }

    /**
     * 创建队列
     */
    @Test
    public void creatQueue(){
        amqpAdmin.declareQueue(new Queue("admin.queue",true));
        System.out.println("创建完成");
    }

    /**
     * 创建Binding
     */
    @Test
    public void creatBinding(){
        Binding binding = new Binding("admin.queue", Binding.DestinationType.QUEUE,"admin.exchange","admin.queue",null);
        amqpAdmin.declareBinding(binding);
        System.out.println("创建完成");
    }
}
