package com.liangxinyu.bootlaunch.service;

import com.liangxinyu.bootlaunch.model.AjaxResponse;
import com.liangxinyu.bootlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Slf4j
public class ArticleTestService {
    public String saveArticle( Article article){
        log.info("saveArticle:{}",article);
        return "测试成功";
    }
}
