package cn.syl.service.impl;

import cn.syl.mapper.CategoryMapper2;
import cn.syl.mapper.TCategoryMapper;
import cn.syl.pojo.Category2;
import cn.syl.pojo.CategoryVo;
import cn.syl.pojo.TCategory;
import cn.syl.pojo.TCategoryExample;
import cn.syl.service.CategoryService;
import cn.syl.service.CategoryService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl2 implements CategoryService2 {
    @Autowired
    private CategoryMapper2 categoryMapper;


    public List<Category2> findAllWithoutEmbedded() {
        return categoryMapper.findAllWithoutEmbedded();
    }

    @Transactional
    public void addCategory(Category2 entity) {
        categoryMapper.addCategory(entity);
    }

    @Transactional
    public void deleteCategory(Long id) {
        //查询他们的爸爸
        List<Category2> listById = categoryMapper.findListByParentId(id);

        for (Category2 cate : listById){
                deleteCategory(cate.getCategoryId());
            }

        categoryMapper.deleteCategory(id);

    }


}
