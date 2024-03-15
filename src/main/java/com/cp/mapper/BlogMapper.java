package com.cp.mapper;

import com.cp.pojo.entity.Blog;
import com.cp.pojo.vo.BlogVo;

import java.util.List;

public interface BlogMapper {

    List<Blog> selectAll();

    void deleteById(Integer id);

    void add(Blog blog);

    Blog selectById(Integer id);

    void update(Blog blog);

    List<BlogVo> selectByPage(int offset, Integer pageSize);

    int selectTotalCount();

    void deleteAll(Integer[] ids);
}
