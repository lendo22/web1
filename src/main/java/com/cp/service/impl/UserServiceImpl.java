package com.cp.service.impl;

import com.cp.mapper.UserMapper;
import com.cp.pojo.entity.User;
import com.cp.service.IUserService;
import com.cp.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    //业务
    @Override
    public List<User> selectAll() {

        List<User> list = userMapper.selectAll();
        for (User user : list) {
            user.setName("cp-"+user.getName());
        }
        return list;

    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User login(String name, String password) {
        return userMapper.login(name, password);
    }


    // TotalCount=101
    // pageSize=10

    @Override
    public PageInfo selectByPage(Integer pageNo, Integer pageSize) {
        // limit
        int offset = (pageNo - 1) * pageSize;
        // 查询当前页数据
        List<User> list = userMapper.selectByPage(offset,pageSize);
        // 查找总的数据，目的是计算总的页数totalPage
        int totalCount = userMapper.selectTotalCount();
        //Math.ceil向上取整
        int totalPage =(int)Math.ceil((double) totalCount / pageSize);
        return new PageInfo<User>(list,totalPage,pageNo,pageSize);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        userMapper.deleteAll(ids);
    }


}
