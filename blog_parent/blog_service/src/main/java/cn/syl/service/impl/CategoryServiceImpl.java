package cn.syl.service.impl;

import cn.syl.mapper.TCategoryMapper;
import cn.syl.pojo.CategoryVo;
import cn.syl.pojo.TCategory;
import cn.syl.pojo.TCategoryExample;
import cn.syl.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private TCategoryMapper categoryMapper;

    @Transactional
    public void addCategory(TCategory category) {
        categoryMapper.insert(category);
    }

    public List<CategoryVo> findAll() {
        TCategoryExample e = new TCategoryExample();
        return categoryMapper.findAll();
       // return categoryMapper.selectByExample(e);
    }

    public CategoryVo findCategoryById(Long id) {
       return categoryMapper.findCategoryById(id);
    }

    public List<TCategory> findCategoryParentList() {
        TCategoryExample e = new TCategoryExample();
        return categoryMapper.selectByExample(e);
    }

    public void updateCategory(TCategory category) {
        categoryMapper.updateByPrimaryKey(category);
    }
}
