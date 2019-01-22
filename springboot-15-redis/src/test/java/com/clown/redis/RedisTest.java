package com.clown.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void stringSet(){
        stringRedisTemplate.opsForValue().set("msg","clown is laughing at you...",30,TimeUnit.SECONDS);
    }

    @Test
    public void stringGet(){
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

    @Test
    public void stringDelete(){
        Boolean msg = stringRedisTemplate.delete("msg");
        System.out.println(msg);
    }

    //查看key还有多长时间过期
    @Test
    public void stringTime(){
        Long time = stringRedisTemplate.getExpire("msg",TimeUnit.SECONDS);
        System.out.println(time);
    }

    @Test
    public void listSet(){
        stringRedisTemplate.opsForList().leftPush("myList","1");
        stringRedisTemplate.opsForList().leftPush("myList","2");
        stringRedisTemplate.opsForList().leftPush("myList","3");
        stringRedisTemplate.opsForList().leftPush("myList","4");
        stringRedisTemplate.opsForList().leftPush("myList","5");
    }

    /**
     * 此方法是将从左边出队一个元素,就是拿出一个值,myList中就不存在这个值了,5就不存在了
     */
    @Test
    public void listLeftGet(){
        String value = stringRedisTemplate.opsForList().leftPop("myList");
        System.out.println(value);
    }

    /**
     * 此方法是将从右边出队一个元素,就是拿出一个值,myList中就不存在这个值了,1就不存在了
     */
    @Test
    public void listRightGet(){
        String value = stringRedisTemplate.opsForList().rightPop("myList");
        System.out.println(value);
    }
}
