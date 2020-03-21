package com.liangxinyu.bootlaunch.service;

import com.liangxinyu.bootlaunch.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleRestService {
    public Article saveArticle(Article article);
    public void deleteArticle(Long id);
    public void updateArticle(Article article);
    public Article getArticle(Long id);
    public List<Article> getAll();
}
