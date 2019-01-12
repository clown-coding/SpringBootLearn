package com.clown.configfile.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/12
 * @description: person
 **/

/**
 * @ConfigurationProperties: 告诉SpringBoot将本类中的所有属性值和配置文件中的相关配置进行绑定
 *      prefix = "person" : 配置文件中哪个所有的属性进行--映射
 *      某人从全局配置文件中获取值
 * [注意]: 只有这个组件是容器中的组件,才能使用 + @Component注解
 */
@Data
@Component
@ConfigurationProperties(prefix = "person")
@Validated              //JSR303数据校验
public class Person {

    //@Value("${person.name}")
    private String name;

    //@Value("#{11*2}")  //SpEL表达式
    private Integer age;

    //@Value("true")
    private Boolean boss;

    //@Value("${person.birthday}")
    private Date birthday;

    @Email
    private String email;

    private Map<String,Object> map;

    private List<Object> list;

    private Dog dog;
}
