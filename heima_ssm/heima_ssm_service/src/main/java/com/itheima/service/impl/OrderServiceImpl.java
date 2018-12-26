package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.OrderDao;
import com.itheima.domain.Order;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Order> findAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return orderDao.findAll();
    }

    @Override
    public Order findById(String id) {
        return orderDao.findById(id);
    }
}
