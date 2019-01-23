package com.clown.article.config;

import com.clown.article.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
 **/
@Configuration
public class MyConfig {

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }

}
