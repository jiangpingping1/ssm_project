package com.itheima.dao;

import com.itheima.domain.UserInfo;
import com.itheima.utils.URInfo;

import java.util.List;

public interface UserDao {
    public UserInfo findByUsername(String username);
    public List<UserInfo> findAll(String str);
    public UserInfo findById(String id);
    public void save(UserInfo userInfo);
    public void update(UserInfo userInfo);
    public void insert(URInfo urInfo);
    public void delete(URInfo urInfo);
}
