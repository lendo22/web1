package com.cp.mapper;

import com.cp.pojo.entity.Auth;

import java.util.List;

public interface AuthMapper {

    List<Auth> selectAll();

    void deleteById(Integer id);

    void add(Auth auth);

    Auth selectById(Integer id);

    void update(Auth auth);

    List<Auth> selectByPage(int offset, Integer pageSize);

    int selectTotalCount();

    void deleteAll(Integer[] ids);

    List<Auth> selectByRoleId(Integer id);
}
