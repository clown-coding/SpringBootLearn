package com.clown.search.mapper;

import com.clown.search.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleSearchMapper extends ElasticsearchRepository<Article,String> {
    //使用方法命名查询
    //模糊查询title与content
    Page<Article> findArticleByTitleOrContentLike(String title, String content, Pageable pageable);
}
