package com.cp.service;

import com.cp.pojo.entity.User;
import com.cp.util.PageInfo;

import java.util.List;

public interface IUserService {
    List<User> selectAll();

    void deleteById(Integer id);

    void add(User user);

    User selectById(Integer id);

    void update(User user);

    User login(String name, String password);

    PageInfo selectByPage(Integer pageNo, Integer pageSize);

    void deleteAll(Integer[] ids);
}
