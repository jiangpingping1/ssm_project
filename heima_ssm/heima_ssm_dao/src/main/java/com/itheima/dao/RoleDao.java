package com.itheima.dao;

import com.itheima.domain.Role;
import com.itheima.utils.RPInfo;

import java.util.List;

public interface RoleDao {
    public List<Role> findByUserId(String userId);
    public List<Role> findAll(String str);
    public List<Role> findAll2(String userId);
    public List<String> findAllRoleId();
    public Role findById(String id);
    public void delete(RPInfo rpInfo);
    public void insert(RPInfo rpInfo);
}
