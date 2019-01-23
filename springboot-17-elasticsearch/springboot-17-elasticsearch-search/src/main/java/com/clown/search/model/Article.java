package com.clown.search.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/23
 * elasticsearch的文章实体类
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "springboot_elasticsearch",type = "article")
public class Article implements Serializable {

    @Id
    private String id;      //ID

    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String title;   //文章标题

    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String content; //文章正文

    private String state;   //审核状态
}
