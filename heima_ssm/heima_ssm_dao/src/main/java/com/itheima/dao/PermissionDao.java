package com.itheima.dao;

import com.itheima.domain.Permission;

import java.util.List;

public interface PermissionDao {
    public List<Permission> findByRoleId(String roleId);
}
