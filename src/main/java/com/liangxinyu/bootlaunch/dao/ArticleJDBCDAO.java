package com.liangxinyu.bootlaunch.dao;

import com.liangxinyu.bootlaunch.pojo.ArticleVO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ArticleJDBCDAO {
    @Resource
    private JdbcTemplate primaryJdbcTemplate;

    //保存文章
    public void  save(ArticleVO article, JdbcTemplate jdbcTemplate){
        if(jdbcTemplate == null){
            jdbcTemplate=primaryJdbcTemplate;
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
            jdbcTemplate=primaryJdbcTemplate;
        }
        jdbcTemplate.update("delete from article where id=?",new Object[]{id});
    }
    //更新文章
    public void updateById(ArticleVO article, JdbcTemplate jdbcTemplate){
        if(jdbcTemplate == null){
            jdbcTemplate=primaryJdbcTemplate;
        }
        jdbcTemplate.update("update article set author=?,title=?,content=?,create_time=? where id=?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
    }
    //根据id查找文章
    public ArticleVO findById(Long  id, JdbcTemplate jdbcTemplate){
        if(jdbcTemplate == null){
            jdbcTemplate=primaryJdbcTemplate;
        }
        return (ArticleVO)jdbcTemplate.queryForObject("SELECT * FROM article WHERE id=?",
                new Object[]{id},new BeanPropertyRowMapper<>(ArticleVO.class));
    }
    //查询所有
    public List<ArticleVO> findAll(JdbcTemplate jdbcTemplate){
        if(jdbcTemplate == null){
            jdbcTemplate=primaryJdbcTemplate;
        }
            return (List<ArticleVO>)jdbcTemplate.query("select * from article",new BeanPropertyRowMapper(ArticleVO.class));
    }
    //保存文章
    public void  save(ArticleVO article){
        primaryJdbcTemplate.update("insert into article(author, title, content, create_time) values(?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }
    //删除文章
    public void deleteById(Long id){

        primaryJdbcTemplate.update("delete from article where id=?",new Object[]{id});
    }
    //更新文章
    public void updateById(ArticleVO article){
        primaryJdbcTemplate.update("update article set author=?,title=?,content=?,create_time=? where id=?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
    }
    //根据id查找文章
    public ArticleVO findById(Long  id){
        return (ArticleVO)primaryJdbcTemplate.queryForObject("SELECT * FROM article WHERE id=?",
                new Object[]{id},new BeanPropertyRowMapper<>(ArticleVO.class));
    }
    //查询所有
    public List<ArticleVO> findAll(){

        return (List<ArticleVO>)primaryJdbcTemplate.query("select * from article",new BeanPropertyRowMapper(ArticleVO.class));
    }
}
