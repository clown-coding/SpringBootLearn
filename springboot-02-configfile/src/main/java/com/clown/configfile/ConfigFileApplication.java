package com.clown.configfile;

import com.clown.configfile.model.People;
import com.clown.configfile.service.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/12
 * @description: 启动类
 **/
//@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class ConfigFileApplication {
    public static void main(String[] args){
        //SpringApplication.run(ConfigFileApplication.class,args);

        //以下为SpringBoot2.0新的参数绑定特性
        ApplicationContext applicationContext = SpringApplication.run(ConfigFileApplication.class, args);
        Binder binder = Binder.get(applicationContext.getEnvironment());
        People people = binder.bind("people", Bindable.of(People.class)).get();
        System.out.println(people);
    }

    @Bean
    public HelloService helloServiceConfigBoot(){
        return new HelloService();
    }
}
