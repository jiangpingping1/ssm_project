package com.itheima.dao;

import com.itheima.domain.Permission;

import java.util.List;

public interface PermissionDao {
    public List<Permission> findByRoleId(String roleId);
    public List<Permission> findAllByRoleId(String roleId);
    public List<String> findAllPermissionId();
    public List<Permission> findAll(String str);
    public void save(Permission permission);
    public Permission findById(String id);
    public void delete(String id);
}
