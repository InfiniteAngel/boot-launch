package com.liangxinyu.bootlaunch.controller;

import com.liangxinyu.bootlaunch.model.AjaxResponse;
import com.liangxinyu.bootlaunch.model.ArticleVO;
import com.liangxinyu.bootlaunch.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/rest")
@Controller
public class ArticleRestController {
    //@RequestMapping(value = "/article",method = POST,produces = "applicatioin/json")
    @Resource
    ArticleRestService articleRestService;
    @Resource
    MongoRepository  mongoRepository;


    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody ArticleVO article){
        /*接受表单提交，可用@RequestParam*/
        articleRestService.saveArticle(article);
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
    public AjaxResponse updateArticle(@PathVariable Long id,@RequestBody  ArticleVO article){
        article.setId(id);
        log.info("updateArticle:{}",article);
        return AjaxResponse.success(article);
    }
    //@RequestMapping(value = "/article/{id}",method = GET,produces = "applicatioin/json")
    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(@PathVariable Integer id){
        log.info("getArticle:{}",id);
        ArticleVO articleVO=articleRestService.getArticle(id);
        return AjaxResponse.success(articleVO);
    }

}
