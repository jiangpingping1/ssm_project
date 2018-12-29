package com.itheima.service;

import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{
    public List<UserInfo> findAll(String str,int pageNum,int pageSize);
    public UserInfo findById(String id);
    public void save(UserInfo userInfo);
    public void update(UserInfo userInfo);
    public void saveRole(String userId, String[] ids);
}
