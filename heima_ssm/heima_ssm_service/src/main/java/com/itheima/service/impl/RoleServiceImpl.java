package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.PermissionDao;
import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import com.itheima.utils.RPInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;
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

    @Override
    public void savePermission(String roleId, String[] ids) {
        if(ids!=null&&ids.length>0){
            List<String> allPermissionId = permissionDao.findAllPermissionId();
            for (String permissionId : allPermissionId) {
                roleDao.delete(new RPInfo(roleId,permissionId));
            }
            for (String permissionId : ids) {
                roleDao.insert(new RPInfo(roleId,permissionId));
            }
        }
    }
}
