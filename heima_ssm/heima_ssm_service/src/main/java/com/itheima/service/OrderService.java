package com.itheima.service;

import com.itheima.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll(String str,int pageNum,int pageSize);
    Order findById(String id);
}
