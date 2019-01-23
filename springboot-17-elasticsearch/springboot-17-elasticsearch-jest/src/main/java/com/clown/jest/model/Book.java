package com.clown.jest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/23
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    private Integer id;
    private String bookName;
    private String author;
    private String content;
}
