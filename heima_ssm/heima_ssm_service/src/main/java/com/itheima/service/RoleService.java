package com.itheima.service;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.utils.RPInfo;

import java.util.List;

public interface RoleService {
    public List<Role> findAll(String str,int pageNum,int pageSize);
    public List<Role> findAll2(String userId);
    public Role findById(String id);
    public void savePermission(String roleId,String[] ids);
}
