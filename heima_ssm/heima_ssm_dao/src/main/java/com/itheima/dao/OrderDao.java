package com.itheima.dao;

import com.itheima.domain.Order;

import java.util.List;

public interface OrderDao {
    List<Order> findAll(String str);
    Order findById(String id);
}
