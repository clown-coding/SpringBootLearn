package com.clown.search.service;

import com.clown.search.model.Article;
import org.springframework.data.domain.Page;

public interface IArticleSearchService {

    //查询所有索引
    Iterable<Article> findAll();

    //根据id查询
    Article findById(String articleId);

    //保存文章索引
    void add(Article article);

    //更新索引
    void update(Article article);

    //删除索引
    void delete(String articleId);

    //模糊查询title与content
    Page<Article> findArticleByTitleOrContentLike(String keyWord, int page, int size);
}
