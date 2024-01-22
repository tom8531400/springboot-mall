package com.lee.springmall.service.impl;

import com.lee.springmall.dao.ProductMapper;
import com.lee.springmall.service.ProductService;
import com.lee.springmall.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductVo getById(Integer product_id) {
        return productMapper.getById(product_id);
    }
}
