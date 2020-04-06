package com.liangxinyu.bootlaunch.controller;

import com.liangxinyu.bootlaunch.model.AjaxResponse;
import com.liangxinyu.bootlaunch.model.Article;
import com.liangxinyu.bootlaunch.model.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@Controller
public class HelloController {

    @Resource
    MongoRepository mongoRepository;
    @PostMapping("/hello")
    public @ResponseBody AjaxResponse save(@RequestBody Article article){
        mongoRepository.save(article);
        return AjaxResponse.success(article);
    }
    public AjaxResponse deleteArticle(@PathVariable String id){
        log.info("deleteArticle:{}",id);
        mongoRepository.deleteById(id);
        return AjaxResponse.success(id);
    }
    //@RequestMapping(value = "/article/{id}",method = PUT,produces = "applicatioin/json")
    @PutMapping("/hello/{id}")
    public AjaxResponse updteArticle(@PathVariable String id,@RequestBody com.liangxinyu.bootlaunch.model.Article article){
        mongoRepository.save(article);
        log.info("updateArticle:{}",article);
        return AjaxResponse.success(article);
    }
    //@RequestMapping(value = "/article/{id}",method = GET,produces = "applicatioin/json")
    @GetMapping("/hello/{id}")
    public AjaxResponse getArticle(@PathVariable String id){

       Optional<Article> article= mongoRepository.findById(id);
        return AjaxResponse.success(article.get());
    }
    @GetMapping("/hello/all")
    public AjaxResponse getAll(){

        List<Article> article= mongoRepository.findAll();
        return AjaxResponse.success(article);
    }

}
