package com.clown.configfile.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/12
 * @description: Student
 **/
@Data
@Component
@ConfigurationProperties(prefix = "student")
public class Student {

    private String id;

    private String name;

    private Integer age;

    private String grade;

    private Dog dog;
}
