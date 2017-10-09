package cn.syl.mapper;

import cn.syl.pojo.TBlog;
import cn.syl.pojo.TBlogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBlogMapper {
    int countByExample(TBlogExample example);

    int deleteByExample(TBlogExample example);

    int deleteByPrimaryKey(Long blogId);

    int insert(TBlog record);

    int insertSelective(TBlog record);

    List<TBlog> selectByExampleWithBLOBs(TBlogExample example);

    List<TBlog> selectByExample(TBlogExample example);

    TBlog selectByPrimaryKey(Long blogId);

    int updateByExampleSelective(@Param("record") TBlog record, @Param("example") TBlogExample example);

    int updateByExampleWithBLOBs(@Param("record") TBlog record, @Param("example") TBlogExample example);

    int updateByExample(@Param("record") TBlog record, @Param("example") TBlogExample example);

    int updateByPrimaryKeySelective(TBlog record);

    int updateByPrimaryKeyWithBLOBs(TBlog record);

    int updateByPrimaryKey(TBlog record);
}