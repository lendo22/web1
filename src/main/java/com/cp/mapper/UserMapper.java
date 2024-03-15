package com.cp.mapper;

import com.cp.pojo.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    void deleteById(Integer id);

    void add(User user);

    User selectById(Integer id);

    void update(User user);


    User login(String name, String password);

    List<User> selectByPage(int offset, Integer pageSize);

    int selectTotalCount();

    void deleteAll(Integer[] ids);
}
