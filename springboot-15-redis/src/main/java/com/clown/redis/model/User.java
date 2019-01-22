package com.clown.redis.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
 **/
@Data
public class User implements Serializable {

    private Integer id;
    private String username;
    private String password;
}
