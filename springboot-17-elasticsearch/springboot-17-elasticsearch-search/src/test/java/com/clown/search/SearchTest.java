package com.clown.search;

import com.clown.search.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/23
 *
 *  使用elasticsearchTemplate操作索引库
 *
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SearchTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void searchTest(){

        //使用queryStringQuery完成单字符串查询
        String word = "springboot";
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryStringQuery(word)).build();
        List<Article> articleList = elasticsearchTemplate.queryForList(searchQuery, Article.class);
        articleList.stream().forEach(System.out::println);
    }
}
