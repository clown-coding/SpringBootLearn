package com.clown.article.service;

import com.clown.article.model.Article;

import java.util.List;

public interface IArticleService {

    //查询所有文章
    List<Article> findAll();

    //根据id进行查询
    Article findById(String articleId);

    //添加文章
    void add(Article article);

    //更新文章
    void update(Article article);

    //删除文章
    void delete(String articleId);
}
