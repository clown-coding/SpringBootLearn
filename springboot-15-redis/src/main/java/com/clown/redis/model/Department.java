package com.clown.redis.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/20
 **/
@Data
public class Department implements Serializable {

    private Integer id;
    private String departmentName;
}
