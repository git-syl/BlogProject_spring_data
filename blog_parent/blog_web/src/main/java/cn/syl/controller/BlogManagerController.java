package cn.syl.controller;

import cn.syl.pojo.CategoryVo;
import cn.syl.pojo.TCategory;
import cn.syl.pojo.Test;
import cn.syl.service.CategoryService;
import cn.syl.service.ContentService;
import com.alibaba.dubbo.common.json.JSONObject;
import org.apache.log4j.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/background")
public class BlogManagerController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping  //background
    public String showBackground(Model model) {
        List<CategoryVo> list = categoryService.findAll();
        List<TCategory> parentList = categoryService.findCategoryParentList();
        model.addAttribute("categoryList", list);
        model.addAttribute("parentList",parentList);
        return "background/index";
    }

    @RequestMapping("/add")
    public String add(TCategory category) {
        categoryService.addCategory(category);
        return "redirect:/background.html";
    }
    @RequestMapping("/edit")
    public String edit(Long id,Model model){
        CategoryVo categoryVo = categoryService.findCategoryById(id);
        List<TCategory> parentList = categoryService.findCategoryParentList();
        model.addAttribute("categoryVo",categoryVo);
        model.addAttribute("parentList",parentList);
        return "background/edit";
    }
    @RequestMapping("/update")
    public String update(TCategory category){
        categoryService.updateCategory(category);
        return "redirect:/background.html";
    }

}
