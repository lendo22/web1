package com.cp.mapper;

import com.cp.pojo.entity.BlogType;
import com.cp.pojo.vo.BlogTypeCountVo;

import java.util.List;

public interface BlogTypeMapper {

    List<BlogTypeCountVo> selectBlogTypeCount();
    List<BlogType> selectAll();

    void deleteById(Integer id);

    void add(BlogType bolgType);

    BlogType selectById(Integer id);

    void update(BlogType bolgType);

    List<BlogType> selectByPage(int offset, Integer pageSize);

    int selectTotalCount();

    void deleteAll(Integer[] ids);
}
