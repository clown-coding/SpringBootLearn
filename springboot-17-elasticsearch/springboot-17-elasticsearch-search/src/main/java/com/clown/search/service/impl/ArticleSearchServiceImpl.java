package com.clown.search.service.impl;

import com.clown.search.mapper.ArticleSearchMapper;
import com.clown.search.model.Article;
import com.clown.search.service.IArticleSearchService;
import com.clown.search.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class ArticleSearchServiceImpl implements IArticleSearchService {

    @Autowired
    private ArticleSearchMapper articleSearchMapper;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有
     * @return
     */
    @Override
    public Iterable<Article> findAll() {
        return articleSearchMapper.findAll();
    }

    /**
     * 根据id查询索引
     * @param articleId
     * @return
     */
    @Override
    public Article findById(String articleId) {
        return articleSearchMapper.findById(articleId).get();
    }

    /**
     * 保存文章索引
     * @param article
     */
    @Override
    public void add(Article article) {
        article.setId(String.valueOf(idWorker.nextId()));
        articleSearchMapper.save(article);
    }

    /**
     * 更新索引
     * @param article
     */
    @Override
    public void update(Article article) {
        articleSearchMapper.save(article);
    }

    /**
     * 删除索引
     * @param articleId
     */
    @Override
    public void delete(String articleId) {
        articleSearchMapper.deleteById(articleId);
    }

    /**
     * 模糊查询
     * @param keyWord
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Article> findArticleByTitleOrContentLike(String keyWord, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page-1,size);
        return articleSearchMapper.findArticleByTitleOrContentLike(keyWord,keyWord,pageRequest);
    }
}
