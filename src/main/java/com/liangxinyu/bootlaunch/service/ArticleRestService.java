package com.liangxinyu.bootlaunch.service;

import com.liangxinyu.bootlaunch.model.ArticleVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleRestService {
    ArticleVO saveArticle(ArticleVO article);

    void deleteArticle(Integer id);

    void updateArticle(ArticleVO article);

    ArticleVO getArticle(Integer id);

    List<ArticleVO> getAll();
}
