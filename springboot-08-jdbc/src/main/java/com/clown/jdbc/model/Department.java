package com.clown.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/19
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private Integer id;

    private String departmentName;
}
