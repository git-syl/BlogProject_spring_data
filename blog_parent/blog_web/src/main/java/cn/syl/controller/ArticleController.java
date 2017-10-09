package cn.syl.controller;

import cn.syl.pojo.Blog2;
import cn.syl.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/ajaxList")
    @ResponseBody
    public List<Blog2> ajaxList(@RequestParam(value = "id",defaultValue = "1") Long categoryId){
        return articleService.findListByBlogId(categoryId);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("blogList",blogList);
    }
}
