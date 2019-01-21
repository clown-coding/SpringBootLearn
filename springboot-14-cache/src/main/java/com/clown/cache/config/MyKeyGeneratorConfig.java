package com.clown.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/21
 *
 * 自定义缓存key的生成策略,
 * 生成的key为 方法名+参数
 *
 *
 **/
@Configuration
public class MyKeyGeneratorConfig {

    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return new  KeyGenerator(){
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName()+"["+ Arrays.asList(params).toString() +"]";
            }
        };
    }
}
