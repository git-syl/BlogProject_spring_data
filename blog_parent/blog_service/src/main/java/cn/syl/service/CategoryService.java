package cn.syl.service;

import cn.syl.pojo.CategoryVo;
import cn.syl.pojo.TCategory;

import java.util.List;

public interface CategoryService {
    void addCategory(TCategory category);
    List<CategoryVo> findAll();
    CategoryVo findCategoryById(Long id);

    List<TCategory> findCategoryParentList();

    void updateCategory(TCategory category);

}
