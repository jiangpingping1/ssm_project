package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(required = false) String str, @RequestParam(required = false,defaultValue = "1") int pageNum, @RequestParam(required = false,defaultValue = "5") int pageSize){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = roleService.findAll(str, pageNum, pageSize);
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("str",str);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findById(id);
        modelAndView.addObject("role",role);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }
}
