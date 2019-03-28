package com.itheima.service;

import com.itheima.domain.Permission;

import java.util.List;

public interface PermissionService {
    public List<Permission> findAllByRoleId(String roleId);
    List<Permission> findAll(String str, int pageNum, int pageSize);
    public void save(Permission permission);
    public Permission findById(String id);
    public void delete(String id);
}
