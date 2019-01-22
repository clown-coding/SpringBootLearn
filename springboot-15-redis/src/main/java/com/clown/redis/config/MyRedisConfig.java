package com.clown.redis.config;

import com.clown.redis.model.Department;
import com.clown.redis.model.Employee;
import com.clown.redis.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.net.UnknownHostException;
import java.time.Duration;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
 *
 * redis默认使用JDK的序列化器,一般都会将其配置为json序列化器
 *
 **/
@Configuration
public class MyRedisConfig {

    //将数据进行序列化
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    //将redis序列化器进行转换,并且该模板的返回值是employee
    @Bean
    public RedisTemplate<Object, Employee> employeeRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<>(Employee.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    //将redis序列化器进行转换,并且该模板的返回值是department
    @Bean
    public RedisTemplate<String, Department> departmentRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<String, Department> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Department> serializer = new Jackson2JsonRedisSerializer<>(Department.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    //将redis序列化器进行转换,并且该模板的返回值是user
    @Bean
    public RedisTemplate<Object, User> userRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, User> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<User> serializer = new Jackson2JsonRedisSerializer<>(User.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    //定制缓存规则
    @Bean
    public RedisCacheManager userRedisCacheManager(RedisConnectionFactory connectionFactory){
        //创建一个redisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        RedisSerializer<Object> jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair.fromSerializer(jsonRedisSerializer);
        RedisCacheConfiguration defaultCacheConfig=RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
        //设置默认过期时间是30秒
        defaultCacheConfig.entryTtl(Duration.ofSeconds(30));
        //初始化RedisCacheManager
        return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
    }


}
