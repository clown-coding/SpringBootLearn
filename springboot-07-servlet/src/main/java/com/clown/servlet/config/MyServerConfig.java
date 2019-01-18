package com.clown.servlet.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/18
 **/
@Configuration
public class MyServerConfig {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> factoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {

            //定制嵌入式的servlet容器相关的规则
            @Override
            public void customize(ConfigurableWebServerFactory factory){
                //修改端口号
                factory.setPort(9090);
            }
        };
    }
}
