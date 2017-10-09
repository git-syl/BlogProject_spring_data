package cn.syl.mapper;

import cn.syl.pojo.Category2;
import java.util.List;

public interface CategoryMapper2 {


    List<Category2> findAll();
    List<Category2> findListByParentId(Long id);
    List<Category2> findAllWithoutEmbedded();
    void addCategory(Category2 entity);

    void deleteCategory(Long id);
}
