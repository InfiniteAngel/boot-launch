package com.liangxinyu.bootlaunch.controller;

import com.liangxinyu.bootlaunch.model.AjaxResponse;
import com.liangxinyu.bootlaunch.model.Article;
import com.liangxinyu.bootlaunch.service.ArticleRestService;
import com.liangxinyu.bootlaunch.service.ArticleTestService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Slf4j
@RestController
@RequestMapping("/rest")
@Controller
public class ArticleRestController {
    //@RequestMapping(value = "/article",method = POST,produces = "applicatioin/json")
    @Resource
    ArticleTestService articleTestService;
    @Resource
    ArticleRestService articleRestService;

    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "文章标题", required = true, dataType = "String"),
            @ApiImplicitParam(name = "content", value = "文章内容", required = true, dataType = "String"),
            @ApiImplicitParam(name = "author", value = "文章作者", required = true, dataType = "String")})
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=AjaxResponse.class),
            @ApiResponse(code=400,message="用户输入错误",response=AjaxResponse.class),
            @ApiResponse(code=500,message="系统内部错误",response=AjaxResponse.class)})
    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody  Article article){
        /*接受表单提交，可用@RequestParam*/
        //public AjaxResponse  saveArticle(@RequestParam Long id,
        Article article1=articleRestService.saveArticle(article);
        log.info("saveArticle:{}",article1);
        log.info("arrticleRestService return:"+article1);
        return AjaxResponse.success(article1);
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
