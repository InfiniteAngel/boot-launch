package com.liangxinyu.bootlaunch.service.imp;

import com.liangxinyu.bootlaunch.dao.ArticleJDBCDAO;
import com.liangxinyu.bootlaunch.model.Article;
import com.liangxinyu.bootlaunch.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleRestServiceImpl implements ArticleRestService {
    @Resource
    private ArticleJDBCDAO  articleJDBCDAO;
    @Override
    @Transactional
    public Article saveArticle(Article article) {
        articleJDBCDAO.save(article);
        return article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleJDBCDAO.updateById(article);
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll();
    }
}