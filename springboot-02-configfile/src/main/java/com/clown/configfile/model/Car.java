package com.clown.configfile.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/12
 * @description: Car
 **/
@Data
@Component
@PropertySource(value = {"classpath:car.properties"})
@ConfigurationProperties(prefix = "car")
public class Car {

    private String brand;

    private String performance;
}
