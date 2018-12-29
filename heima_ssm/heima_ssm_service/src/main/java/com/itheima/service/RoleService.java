package com.itheima.service;

import com.itheima.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll(String str,int pageNum,int pageSize);
    public List<Role> findAll2(String userId);
    public Role findById(String id);
}
