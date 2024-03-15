package com.cp.service;

import com.cp.pojo.entity.Blog;
import com.cp.util.PageInfo;

import java.util.List;

public interface IBlogService {
    List<Blog> selectAll();

    void deleteById(Integer id);

    void add(Blog blog);

    Blog selectById(Integer id);

    void update(Blog blog);

    PageInfo selectByPage(Integer pageNo, Integer pageSize);

    void deleteAll(Integer[] ids);
}
