package com.liangxinyu.bootlaunch.service.imp;

import com.liangxinyu.bootlaunch.Utils.DozerUtils;
import com.liangxinyu.bootlaunch.generator.bd1804.Student;
import com.liangxinyu.bootlaunch.generator.bd1804.StudentExample;
import com.liangxinyu.bootlaunch.generator.bd1804.StudentMapper;
import com.liangxinyu.bootlaunch.generator.testdb.Article;
import com.liangxinyu.bootlaunch.generator.testdb.ArticleMapper;
import com.liangxinyu.bootlaunch.model.ArticleVO;
import com.liangxinyu.bootlaunch.service.ArticleRestService;

import org.dozer.Mapper;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ArticleRestServiceImpl implements ArticleRestService {
    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private StudentMapper studentMapper;

    //新增
    @Override
    @Transactional
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.insert(articlePO);
        Student student = new Student();
        student.setName("liuyifei");
        student.setGender("yifei");
        studentMapper.insert(student);
        int a =4/0;
        return null;
    }

    //删除
    @Override
    public void deleteArticle(Integer id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    //更新
    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.updateByPrimaryKeySelective(articlePO);
    }

    //查询
    @Override
    public ArticleVO getArticle(Integer id) {
        return dozerMapper.map(articleMapper.selectByPrimaryKey(id),ArticleVO.class);
    }
    //查询所有
    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articles,ArticleVO.class);
    }
}
