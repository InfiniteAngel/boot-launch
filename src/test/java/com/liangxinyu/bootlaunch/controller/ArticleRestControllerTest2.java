package com.liangxinyu.bootlaunch.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.liangxinyu.bootlaunch.model.Article;
import com.liangxinyu.bootlaunch.service.ArticleTestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(ArticleRestController.class)
public class ArticleRestControllerTest2 {
    @Resource
    private MockMvc mockMvc;
    @MockBean
    ArticleTestService articleTestService;
    /*@Before
    public void saveUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleRestController()).build();
    }*/
    @Test
    public void saveAriticle() throws Exception {
        String article = "{\n"+
                             "\"id\":1,\n"+
                             "\"author\":\"liangxinyu\",\n"+
                            "\"title\":\"Spring Boot\",\n"+
                            "\"content\":\"c\",\n"+
                            "\"createTime\":\"2017-07-16 05:23:34\",\n"+
                "\"reader\":[{\"name\":\"liangxinyu\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n"+
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Article articleObj = objectMapper.readValue(article,Article.class);
        articleTestService.saveArticle(articleObj);

        //打桩
        when(articleTestService.saveArticle(articleObj)).thenReturn("ok");
        //模拟Get请求
        //mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}",userId));
        //模拟Post请求
        //mockMvc.perform(MockMvcRequestBuilders.post("uri",parameters));
        //模拟文件上传
        //mockMvc.perform(MockMvcRequestBuilders.multipart("uri").file("fileName","file".getBytes()));
        //模拟session和cookies
       // mockMvc.perform(MockMvcRequestBuilders.get("uri").sessionAttr("name","value"));
        //mockMvc.perform(MockMvcRequestBuilders.get("uri").cookie(new Cookie("name","value")));
        //设置Http Header:
        //mockMvc.perform(MockMvcRequestBuilders.get("uri",parameters).contentType("application/x www-form-urlencoded").accept("application/json").header("",""));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST,"/rest/article")
                .contentType("application/json").content(article))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("liangxinyu"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
                .andDo(print())
                .andReturn();
        log.info(result.getResponse().getContentAsString());
    }
}