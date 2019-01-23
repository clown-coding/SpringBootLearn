package com.clown.search.controller;

import com.clown.search.model.Article;
import com.clown.search.service.IArticleSearchService;
import com.clown.search.utils.PageResult;
import com.clown.search.utils.Result;
import com.clown.search.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleSearchController {

    @Autowired
    private IArticleSearchService articleSearchService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    public Result findAll(){
        Iterable<Article> articleIterable = articleSearchService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",articleIterable);

    }

    /**
     * 根据id查询索引
     * @return
     */
    @GetMapping("/{articleId}")
    public Result findById(@PathVariable("articleId") String articleId){
        Article article = articleSearchService.findById(articleId);
        return new Result(true, StatusCode.OK,"查询成功",article);
    }

    /**
     * 添加索引
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Article article){
        articleSearchService.add(article);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    /**
     * 更新索引
     * @return
     */
    @PutMapping("/{articleId}")
    public Result update(@PathVariable("articleId") String articleId,@RequestBody Article article){
        article.setId(articleId);
        articleSearchService.update(article);
        return new Result(true, StatusCode.OK,"更新成功");
    }

    /**
     * 删除索引
     * @return
     */
    @DeleteMapping("/{articleId}")
    public Result delete(@PathVariable("articleId") String articleId){
        articleSearchService.delete(articleId);
        return new Result(true, StatusCode.OK,"删除成功");
    }

    /**
     * 模糊查询title与content
     * @return
     */
    @GetMapping("/search/{keyWord}/{page}/{size}")
    public Result findArticleByTitleOrContentLike(@PathVariable("keyWord") String keyWord,@PathVariable("page") int page,@PathVariable("size") int size){
        Page<Article> articlePage = articleSearchService.findArticleByTitleOrContentLike(keyWord, page, size);
        PageResult<Article> pageResult = new PageResult<>(articlePage.getTotalElements(),articlePage.getContent());
        return new Result(true, StatusCode.OK,"查询成功",pageResult);
    }


}
