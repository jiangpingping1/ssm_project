package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll(String str,int pageNum,int pageSize);
    Product findById(String id);
    void delete(String[] ids);
    void save(Product product);
    void update(Product product);
}
