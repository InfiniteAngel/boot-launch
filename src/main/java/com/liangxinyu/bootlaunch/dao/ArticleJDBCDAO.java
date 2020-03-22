package com.liangxinyu.bootlaunch.dao;

import com.liangxinyu.bootlaunch.model.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ArticleJDBCDAO {
    @Resource
    private JdbcTemplate uatJdbcTemplate;

    //保存文章
    public void  save(Article article,JdbcTemplate jdbcTemplate){
        if(jdbcTemplate == null){
            jdbcTemplate=uatJdbcTemplate;
        }

        jdbcTemplate.update("insert into article(author, title, content, create_time) values(?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }
    //删除文章
    public void deleteById(Long id,JdbcTemplate jdbcTemplate){
        if(jdbcTemplate == null){
            jdbcTemplate=uatJdbcTemplate;
        }
        jdbcTemplate.update("delete from article where id=?",new Object[]{id});
    }
    //更新文章
    public void updateById(Article article,JdbcTemplate jdbcTemplate){
        if(jdbcTemplate == null){
            jdbcTemplate=uatJdbcTemplate;
        }
        jdbcTemplate.update("update article set author=?,title=?,content=?,create_time=? where id=?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
    }
    //根据id查找文章
    public Article findById(Long  id,JdbcTemplate jdbcTemplate){
        if(jdbcTemplate == null){
            jdbcTemplate=uatJdbcTemplate;
        }
        return (Article)jdbcTemplate.queryForObject("SELECT * FROM article WHERE id=?",
                new Object[]{id},new BeanPropertyRowMapper<>(Article.class));
    }
    //查询所有
    public List<Article> findAll(JdbcTemplate jdbcTemplate){
        if(jdbcTemplate == null){
            jdbcTemplate=uatJdbcTemplate;
        }
            return (List<Article>)jdbcTemplate.query("select * from article",new BeanPropertyRowMapper(Article.class));
    }
    //保存文章
    public void  save(Article article){
        uatJdbcTemplate.update("insert into article(author, title, content, create_time) values(?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }
    //删除文章
    public void deleteById(Long id){

       uatJdbcTemplate.update("delete from article where id=?",new Object[]{id});
    }
    //更新文章
    public void updateById(Article article){
        uatJdbcTemplate.update("update article set author=?,title=?,content=?,create_time=? where id=?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
    }
    //根据id查找文章
    public Article findById(Long  id){
        return (Article)uatJdbcTemplate.queryForObject("SELECT * FROM article WHERE id=?",
                new Object[]{id},new BeanPropertyRowMapper<>(Article.class));
    }
    //查询所有
    public List<Article> findAll(){

        return (List<Article>)uatJdbcTemplate.query("select * from article",new BeanPropertyRowMapper(Article.class));
    }
}
