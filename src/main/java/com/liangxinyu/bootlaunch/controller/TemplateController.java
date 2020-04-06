package com.liangxinyu.bootlaunch.controller;

import com.liangxinyu.bootlaunch.model.ArticleVO;
import com.liangxinyu.bootlaunch.service.ArticleRestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/templateJ")
public class TemplateController {

    @Resource
    ArticleRestService articleRestService;

    @GetMapping("/jsp")
    public String index(String name, Model model) {

        List<ArticleVO> articles = articleRestService.getAll();

        model.addAttribute("articles", articles);

        //模版名称，实际的目录为：src/main/webapp/WEB-INF/jsp/jsptemp.jsp
        return "/jsptemp";
    }
}
