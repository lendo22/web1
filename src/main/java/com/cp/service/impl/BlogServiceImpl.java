package com.cp.service.impl;

import com.cp.mapper.BlogMapper;
import com.cp.pojo.entity.Blog;
import com.cp.pojo.vo.BlogVo;
import com.cp.service.IBlogService;
import com.cp.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private BlogMapper blogMapper;

    //业务
    @Override
    public List<Blog> selectAll() {

        List<Blog> list = blogMapper.selectAll();
        return list;

    }

    @Override
    public void deleteById(Integer id) {
        blogMapper.deleteById(id);
    }

    @Override
    public void add(Blog blog) {
        blogMapper.add(blog);
    }

    @Override
    public Blog selectById(Integer id) {
        return blogMapper.selectById(id);
    }

    @Override
    public void update(Blog blog) {
        blogMapper.update(blog);
    }




    // TotalCount=101
    // pageSize=10

    @Override
    public PageInfo selectByPage(Integer pageNo, Integer pageSize) {
        // limit
        int offset = (pageNo - 1) * pageSize;
        // 查询当前页数据
        List<BlogVo> list = blogMapper.selectByPage(offset,pageSize);
        // 查找总的数据，目的是计算总的页数totalPage
        int totalCount = blogMapper.selectTotalCount();
        //Math.ceil向上取整
        int totalPage =(int)Math.ceil((double) totalCount / pageSize);
        return new PageInfo<BlogVo>(list,totalPage,pageNo,pageSize);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        blogMapper.deleteAll(ids);
    }


}
