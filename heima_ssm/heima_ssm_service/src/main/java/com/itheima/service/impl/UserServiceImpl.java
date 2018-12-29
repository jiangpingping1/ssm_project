package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import com.itheima.utils.URInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(username);
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==1?true:false,true,true,true,getRoles(userInfo));
        return user;
    }
    public List<SimpleGrantedAuthority> getRoles(UserInfo userInfo){
        ArrayList<SimpleGrantedAuthority> roles = new ArrayList<>();
        for (Role role : userInfo.getRoles()) {
            SimpleGrantedAuthority sga = new SimpleGrantedAuthority("ROLE_" + role.getRoleName());
            roles.add(sga);
        }
        return roles;
    }

    @Override
    public List<UserInfo> findAll(String str,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return userDao.findAll(str);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void save(UserInfo userInfo) {
        userDao.save(userInfo);
    }

    @Override
    public void update(UserInfo userInfo) {
        userDao.update(userInfo);
    }

    @Override
    public void saveRole(String userId, String[] ids) {
        if(ids!=null){
            List<String> allRoleId = roleDao.findAllRoleId();
            for (String roleId : allRoleId) {
                userDao.delete(new URInfo(userId,roleId));
            }
            for (String roleId : ids) {
                userDao.insert(new URInfo(userId,roleId));
            }
        }
    }

}
