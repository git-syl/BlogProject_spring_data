package cn.syl.controller;

import cn.syl.mapper.CategoryMapper2;
import cn.syl.pojo.Category2;
import cn.syl.service.CategoryService2;
import cn.syl.utils.FastJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService2 categoryService;

    @RequestMapping
    public String list() {
        return "background/index2";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam(value = "name") String categoryName, @RequestParam(value = "pId") Long parentId) {

        Category2 category = new Category2();
        category.setName(categoryName);
        category.setParentId(parentId);
        category.setStatus((byte) 1);

        categoryService.addCategory(category);
        return "background/index2";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("deleteId") Long id){
        categoryService.deleteCategory(id);
        return "background/index2";
    }


    @RequestMapping(value = "/list",produces = { "application/json;charset=UTF-8" }  )
    @ResponseBody
    public String getJson() {
        List<Category2> category2List = categoryService.findAllWithoutEmbedded();
        return FastJsonUtil.toJSONString(category2List);
    }
}
