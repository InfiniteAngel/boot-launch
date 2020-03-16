package com.liangxinyu.bootlaunch.controller;

import com.liangxinyu.bootlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Slf4j
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Article hello(){
        Article article = new Article();
        article.setAuthor("liangxinyu");
        Article article1 = Article.builder().id(2L).author("liangxinyu").build();
        log.info("日志文件");
        return article;
    }
}
