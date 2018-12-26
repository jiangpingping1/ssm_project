package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll(String str,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return productDao.findAll(str);
    }

    @Override
    public Product findById(String id) {
        return productDao.findById(id);
    }

    @Override
    public void delete(String[] ids) {
        if(ids!=null&&ids.length>0){
            for (String id : ids) {
                productDao.delete(id);
            }
        }
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }
}
