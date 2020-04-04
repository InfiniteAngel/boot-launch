package com.liangxinyu.bootlaunch.dao;

import com.liangxinyu.bootlaunch.pojo.ArticleVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleVOJDBCDAOTest {
    @Autowired
    private ArticleJDBCDAO articleJDBCDAO;
    @Autowired
    private JdbcTemplate uatJdbcTemplate;
    @Autowired
    private JdbcTemplate sitJdbcTemplate;


    @Test
    public void testdbc() {
        articleJDBCDAO.save(
                ArticleVO.builder()
                        .author("wufang").title("uat").content("1").createTime(new Date()).build(), uatJdbcTemplate);
        articleJDBCDAO.save(
                ArticleVO.builder()
                        .author("lijiahui").title("sit").content("2").createTime(new Date()).build(), sitJdbcTemplate);
    }
}