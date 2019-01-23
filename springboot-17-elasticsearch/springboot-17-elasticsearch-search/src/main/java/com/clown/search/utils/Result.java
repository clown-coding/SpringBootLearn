package com.clown.search.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回结果的实体类
 * 是否执行成功
 * 状态码
 * 提示信息
 * 返回的数据(也有可能返回的信息没有数据, 如cud操作)
 */
@Data               //lombok依赖不用写get/set/toString/equals/hashcode等方法
@NoArgsConstructor  //省略 空参构造方法
@AllArgsConstructor //省略 全参构造方法
public class Result implements Serializable {

    private boolean flag;      //返回的状态

    private Integer code;       //状态码

    private String message;     //返回的信息

    private Object data;        //返回的数据

    /*三参构造方法,用于cud操作*/
    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
}
