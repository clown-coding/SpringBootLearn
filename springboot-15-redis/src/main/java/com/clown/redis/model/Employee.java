package com.clown.redis.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/20
 **/
@Data
public class Employee implements Serializable {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer dId;
}
