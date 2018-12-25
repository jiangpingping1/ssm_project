package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void delete(String id);
    void save(Product product);
}
