package com.lee.springmall.service;

import com.lee.springmall.dto.ProductRequest;
import com.lee.springmall.vo.ProductVo;

public interface ProductService {

    ProductVo getById(Integer product_id);

    Integer getByNewId();
    boolean createProduct(ProductRequest productRequest);

    void updateProduct(Integer product_id,ProductRequest productRequest);

    void deleteProduct(Integer product_id);
}
