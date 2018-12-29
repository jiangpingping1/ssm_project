package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll(String str,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return roleDao.findAll(str);
    }

    @Override
    public List<Role> findAll2(String userId) {
        return roleDao.findAll2(userId);
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }
}
