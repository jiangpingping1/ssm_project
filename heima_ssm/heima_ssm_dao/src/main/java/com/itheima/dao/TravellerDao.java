package com.itheima.dao;

import com.itheima.domain.Traveller;

public interface TravellerDao {
    public Traveller findByOrderId(String orderId);
}
