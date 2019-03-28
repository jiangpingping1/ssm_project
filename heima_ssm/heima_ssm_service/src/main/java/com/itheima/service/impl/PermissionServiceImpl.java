package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.PermissionDao;
import com.itheima.domain.Permission;
import com.itheima.domain.Product;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll(String str, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return permissionDao.findAll(str);
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public Permission findById(String id) {
        return permissionDao.findById(id);
    }

    @Override
    public void delete(String id) {
        permissionDao.delete(id);
    }

    @Override
    public List<Permission> findAllByRoleId(String roleId) {
        return permissionDao.findAllByRoleId(roleId);
    }
}
