package cn.syl.mapper;

import cn.syl.pojo.Blog2;

import java.util.List;

public interface BlogMapper {
    List<Blog2> findAll();

    List<Blog2> findListByBlogId(Long id);
}
