package com.cp.service;

import com.cp.pojo.entity.Auth;
import com.cp.util.PageInfo;

import java.util.List;

public interface IAuthService {
    List<Auth> selectAll();

    void deleteById(Integer id);

    void add(Auth auth);

    Auth selectById(Integer id);

    void update(Auth auth);

    PageInfo selectByPage(Integer pageNo, Integer pageSize);

    void deleteAll(Integer[] ids);

    List<Auth> selectByRoleId(Integer role);
}
