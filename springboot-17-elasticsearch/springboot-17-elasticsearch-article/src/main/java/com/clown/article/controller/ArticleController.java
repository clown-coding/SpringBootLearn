package com.clown.article.controller;

import com.clown.article.model.Article;
import com.clown.article.service.IArticleService;
import com.clown.article.utils.Result;
import com.clown.article.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    /**
     * 查询所有文章
     * @return
     */
    @GetMapping
    public Result findAll(){
        List<Article> articleList = articleService.findAll();
        if (null == articleList) {
            return new Result(false, StatusCode.ERROR,"无数据");
        }
        return new Result(true, StatusCode.OK,"查询成功",articleList);
    }

    /**
     * 根据id查询文章
     * @param articleId
     * @return
     */
    @GetMapping("/{articleId}")
    public Result findById(@PathVariable("articleId") String articleId){
        Article article = articleService.findById(articleId);
        if (null==article) {
            return new Result(false, StatusCode.ERROR,"无数据");
        }
        return new Result(true, StatusCode.OK,"查询成功",article);
    }

    /**
     * 添加文章
     * @param article
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Article article){
        try {
            articleService.add(article);
            return new Result(true, StatusCode.OK,"添加成功");
        } catch (Exception e) {
            return new Result(false, StatusCode.ERROR,"添加失败");
        }
    }

    /**
     * 更新文章
     * @param articleId
     * @param article
     * @return
     */
    @PutMapping("/{articleId}")
    public Result update(@PathVariable("articleId") String articleId,@RequestBody Article article){
        try {
            article.setId(articleId);
            articleService.update(article);
            return new Result(true, StatusCode.OK,"更新成功");
        } catch (Exception e) {
            return new Result(false, StatusCode.ERROR,"更新失败");
        }
    }

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    @DeleteMapping("/{articleId}")
    public Result delete(@PathVariable("articleId") String articleId){

        try {
            articleService.delete(articleId);
            return new Result(true, StatusCode.OK,"删除成功");
        } catch (Exception e) {
            return new Result(false, StatusCode.ERROR,"删除是啊比");
        }
    }
}
