package cn.syl.service;

import cn.syl.pojo.Category2;
import cn.syl.pojo.CategoryVo;
import cn.syl.pojo.TCategory;

import java.util.List;

public interface CategoryService2 {

    List<Category2> findAllWithoutEmbedded();

    void addCategory(Category2 entity);

    void deleteCategory(Long id);
}
