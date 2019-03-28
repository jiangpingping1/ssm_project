package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Order;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll(@RequestParam(required = false,defaultValue = "1")int pageNum,@RequestParam(required = false,defaultValue = "1")int pageSize,@RequestParam(required = false) String str){
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orders = orderService.findAll(str,pageNum,pageSize);
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        modelAndView.addObject("str",str);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        Order order = orderService.findById(id);
        modelAndView.addObject("order",order);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }
}
