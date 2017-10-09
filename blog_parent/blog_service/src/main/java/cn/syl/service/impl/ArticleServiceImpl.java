package cn.syl.service.impl;

import cn.syl.mapper.BlogMapper;
import cn.syl.pojo.Blog2;
import cn.syl.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl  implements ArticleService{
    @Autowired
    private BlogMapper blogMapper;
    public List<Blog2> findAll() {
        return blogMapper.findAll() ;
    }

    public List<Blog2> findListByBlogId(Long id) {
        return blogMapper.findListByBlogId(id) ;
    }
}
