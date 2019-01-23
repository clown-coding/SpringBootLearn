package com.clown.article.service.impl;

import com.clown.article.mapper.ArticleDao;
import com.clown.article.model.Article;
import com.clown.article.service.IArticleService;
import com.clown.article.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有文章
     * @return
     */
    @Override
    public List<Article> findAll() {
        return articleDao.findAll();
    }

    /**
     * 根据id进行查询,使用双重检测锁,解决缓存穿透问题,第一批用户是去数据库查询,第二批用户则是从缓存中获取
     * @param articleId
     * @return
     */
    @Override
    public Article findById(String articleId) {
        return articleDao.findById(articleId).get();
    }

    /**
     * 添加文章
     * @param article
     */
    @Override
    public void add(Article article) {
        article.setId(String.valueOf(idWorker.nextId()));
        article.setCreatetime(new Date());
        article.setIspublic("0");
        article.setIstop("0");
        article.setState("0");
        articleDao.save(article);
    }

    /**
     * 更新文章
     * @param article
     */
    @Override
    public void update(Article article) {
        article.setUpdatetime(new Date());
        article.setState("0");
        articleDao.save(article);
    }

    /**
     * 删除文章
     * @param articleId
     */
    @Override
    public void delete(String articleId) {
        articleDao.deleteById(articleId);
    }
}
