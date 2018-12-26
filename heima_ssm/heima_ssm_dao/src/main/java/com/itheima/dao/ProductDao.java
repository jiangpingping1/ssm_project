package com.itheima.dao;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll(String str);
    Product findById(String id);
    void save(Product product);
    void delete(String id);
    void update(Product product);
}
