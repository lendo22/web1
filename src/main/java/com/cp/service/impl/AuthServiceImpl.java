package com.cp.service.impl;

import com.cp.mapper.AuthMapper;
import com.cp.pojo.entity.Auth;
import com.cp.service.IAuthService;
import com.cp.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private AuthMapper authMapper;

    //业务
    @Override
    public List<Auth> selectAll() {

        List<Auth> list = authMapper.selectAll();
        return list;

    }

    @Override
    public void deleteById(Integer id) {
        authMapper.deleteById(id);
    }

    @Override
    public void add(Auth auth) {
        authMapper.add(auth);
    }

    @Override
    public Auth selectById(Integer id) {
        return authMapper.selectById(id);
    }

    @Override
    public void update(Auth auth) {
        authMapper.update(auth);
    }




    // TotalCount=101
    // pageSize=10

    @Override
    public PageInfo selectByPage(Integer pageNo, Integer pageSize) {
        // limit
        int offset = (pageNo - 1) * pageSize;
        // 查询当前页数据
        List<Auth> list = authMapper.selectByPage(offset,pageSize);
        // 查找总的数据，目的是计算总的页数totalPage
        int totalCount = authMapper.selectTotalCount();
        //Math.ceil向上取整
        int totalPage =(int)Math.ceil((double) totalCount / pageSize);
        return new PageInfo<Auth>(list,totalPage,pageNo,pageSize);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        authMapper.deleteAll(ids);
    }

    @Override
    public List<Auth> selectByRoleId(Integer id) {
        return authMapper.selectByRoleId(id);
    }
}
