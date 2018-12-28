package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

public interface RoleDao {
    public List<Role> findByUserId(String userId);
}
