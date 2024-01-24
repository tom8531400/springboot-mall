package com.lee.springmall.service.impl;

import com.lee.springmall.dao.ProductMapper;
import com.lee.springmall.dto.ProductRequest;
import com.lee.springmall.service.ProductService;
import com.lee.springmall.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductVo getById(Integer product_id) {
        return productMapper.getById(product_id);
    }

    @Override
    public Integer getByNewId() {
        return productMapper.getByNewId();
    }

    @Override
    public boolean createProduct(ProductRequest productRequest) {
        return productMapper.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer product_id, ProductRequest productRequest) {
        productMapper.updateProduct(product_id,productRequest);
    }

    @Override
    public void deleteProduct(Integer product_id) {
        productMapper.deleteProduct(product_id);
    }

    @Override
    public List<ProductVo> queryAllProductList() {
        return productMapper.queryAllProductList();
    }
}
