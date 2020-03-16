package com.liangxinyu.bootlaunch.controller;

import com.liangxinyu.bootlaunch.model.AjaxResponse;
import com.liangxinyu.bootlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {
    //@RequestMapping(value = "/article",method = POST,produces = "applicatioin/json")
    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody  Article article){
        /*接受表单提交，可用@RequestParam*/
        //public AjaxResponse  saveArticle(@RequestParam Long id,

        log.info("saveArticle:{}",article);
        return AjaxResponse.success(article);
    }
    //@RequestMapping(value = "/article/{id}",method = DELETE,produces = "applicatioin/json")
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id){
        log.info("deleteArticle:{}",id);
        return AjaxResponse.success(id);
    }
    //@RequestMapping(value = "/article/{id}",method = PUT,produces = "applicatioin/json")
    @PutMapping("/article/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id,@RequestBody  Article article){
        article.setId(id);
        log.info("updateArticle:{}",article);
        return AjaxResponse.success(article);
    }
    //@RequestMapping(value = "/article/{id}",method = GET,produces = "applicatioin/json")
    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(@PathVariable Long id){
        log.info("getArticle:{}",id);
        Article article = Article.builder().id(1L).author("liangxinyu").content("sprinmgboot").title("t1").build();
        return AjaxResponse.success(article);
    }
}
