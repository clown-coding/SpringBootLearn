package com.clown.mybatis.model;

import lombok.Data;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/20
 **/
@Data
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer dId;
}
