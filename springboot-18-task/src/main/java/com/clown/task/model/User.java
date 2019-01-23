package com.clown.task.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/23
 **/
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    private Integer id;

    private String username;

    private String password;
}
