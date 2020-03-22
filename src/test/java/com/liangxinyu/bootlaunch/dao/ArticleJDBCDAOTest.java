package com.liangxinyu.bootlaunch.dao;

import com.liangxinyu.bootlaunch.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleJDBCDAOTest {
    @Autowired
    private ArticleJDBCDAO articleJDBCDAO;
    @Autowired
    private JdbcTemplate uatJdbcTemplate;
    @Autowired
    private JdbcTemplate sitJdbcTemplate;


    @Test
    public void testdbc() {
        articleJDBCDAO.save(
                Article.builder()
                        .author("wufang").title("uat").content("1").createTime(new Date()).build(), uatJdbcTemplate);
        articleJDBCDAO.save(
                Article.builder()
                        .author("lijiahui").title("sit").content("2").createTime(new Date()).build(), sitJdbcTemplate);
    }
}