package cn.syl.service;

import cn.syl.pojo.Blog2;

import java.util.List;

public interface ArticleService {
    List<Blog2> findAll();

    List<Blog2> findListByBlogId(Long categoryId);
}
