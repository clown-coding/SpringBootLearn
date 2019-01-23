package com.clown.article.mapper;

import com.clown.article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticleDao extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {
}
