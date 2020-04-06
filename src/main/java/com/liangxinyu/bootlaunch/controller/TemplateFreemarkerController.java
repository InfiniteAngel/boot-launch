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
@RequestMapping("/template")
public class TemplateFreemarkerController {

    @Resource
    ArticleRestService articleRestService;

    @GetMapping("/freemarker")
    public String index(Model model) {

        List<ArticleVO> articles = articleRestService.getAll();

        model.addAttribute("articles", articles);

        //模版名称，实际的目录为：resources/templates/fremarkertemp.html
        return "fremarkertemp";
    }
}
