package com.clown.jpa.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/20
 **/
@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;

    @Column(name = "last_name")
    private String lastName;
    private String email;
    private Integer gender;
    @Column(name = "d_id")
    private Integer dId;
}
