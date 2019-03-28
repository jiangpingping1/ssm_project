package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Permission;
import com.itheima.domain.Product;
import com.itheima.domain.Role;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(required = false) String str, @RequestParam(required = false,defaultValue = "1") int pageNum, @RequestParam(required = false,defaultValue = "5")int pageSize){
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissions = permissionService.findAll(str, pageNum, pageSize);
        PageInfo<Permission> pageInfo = new PageInfo<>(permissions);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("str",str);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }
    @RequestMapping("/save.do")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        Permission permission = permissionService.findById(id);
        modelAndView.addObject("permission",permission);
        modelAndView.setViewName("permission-show");
        return modelAndView;
    }
    @RequestMapping("/delete.do")
    public String delete(String id){
        permissionService.delete(id);
        return "redirect:findAll.do";
    }
}
