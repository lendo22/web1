package com.cp.service.impl;

import com.cp.mapper.BlogTypeMapper;
import com.cp.pojo.entity.BlogType;
import com.cp.pojo.vo.BlogTypeCountVo;
import com.cp.service.IBlogTypeService;
import com.cp.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTypeServiceImpl implements IBlogTypeService {
    @Autowired
    private BlogTypeMapper blogTypeMapper;
    @Override
    public List<BlogTypeCountVo> selectBlogTypeCount() {
        return blogTypeMapper.selectBlogTypeCount();
    }
    //业务
    @Override
    public List<BlogType> selectAll() {

        List<BlogType> list = blogTypeMapper.selectAll();
        return list;

    }

    @Override
    public void deleteById(Integer id) {
        blogTypeMapper.deleteById(id);
    }

    @Override
    public void add(BlogType blogType) {
        blogTypeMapper.add(blogType);
    }

    @Override
    public BlogType selectById(Integer id) {
        return blogTypeMapper.selectById(id);
    }

    @Override
    public void update(BlogType blogType) {
        blogTypeMapper.update(blogType);
    }




    // TotalCount=101
    // pageSize=10

    @Override
    public PageInfo selectByPage(Integer pageNo, Integer pageSize) {
        // limit
        int offset = (pageNo - 1) * pageSize;
        // 查询当前页数据
        List<BlogType> list = blogTypeMapper.selectByPage(offset,pageSize);
        // 查找总的数据，目的是计算总的页数totalPage
        int totalCount = blogTypeMapper.selectTotalCount();
        //Math.ceil向上取整
        int totalPage =(int)Math.ceil((double) totalCount / pageSize);
        return new PageInfo<BlogType>(list,totalPage,pageNo,pageSize);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        blogTypeMapper.deleteAll(ids);
    }
}
