package com.clown.thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

	private Integer id;
    private String lastName;
    private String email;
    /**
     * 1 male, 0 female
     */
    private Integer gender;
    private Integer departmentid;
    private Date birth;

}
