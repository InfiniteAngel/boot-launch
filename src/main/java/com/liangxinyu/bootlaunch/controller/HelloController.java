package com.liangxinyu.bootlaunch.controller;

import com.liangxinyu.bootlaunch.pojo.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public ArticleVO hello(){
        ArticleVO article = new ArticleVO();
        article.setAuthor("liangxinyu");
        ArticleVO article1 = ArticleVO.builder().id(2L).author("liangxinyu").build();
        log.info("日志文件");
        return article;
    }
}
