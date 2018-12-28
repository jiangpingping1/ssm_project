package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(required = false) String str, @RequestParam(required = false,defaultValue = "1") int pageNum, @RequestParam(required = false,defaultValue = "5") int pageSize){
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfos = userService.findAll(str,pageNum,pageSize);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfos);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("str",str);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-show");
        System.out.println(userInfo);
        return modelAndView;
    }
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo){
        String encode = passwordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encode);
        userService.save(userInfo);
        return "redirect:findAll.do";
    }
}
