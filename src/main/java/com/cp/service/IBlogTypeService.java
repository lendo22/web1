package com.cp.service;

import com.cp.pojo.entity.BlogType;
import com.cp.pojo.vo.BlogTypeCountVo;
import com.cp.util.PageInfo;

import java.util.List;

public interface IBlogTypeService {
    List<BlogTypeCountVo> selectBlogTypeCount();
    List<BlogType> selectAll();

    void deleteById(Integer id);

    void add(BlogType blogType);

    BlogType selectById(Integer id);

    void update(BlogType blogType);

    PageInfo selectByPage(Integer pageNo, Integer pageSize);

    void deleteAll(Integer[] ids);
}
