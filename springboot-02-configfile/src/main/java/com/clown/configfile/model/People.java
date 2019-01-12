package com.clown.configfile.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/12
 * @description: People
 **/
@Data
@ConfigurationProperties(prefix = "people")
public class People {

    private String name;

    private List<Object> list;
}
