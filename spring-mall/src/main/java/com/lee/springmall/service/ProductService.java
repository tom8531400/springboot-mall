package com.lee.springmall.service;

import com.lee.springmall.constant.ProductCategory;
import com.lee.springmall.dto.ProductQueryParams;
import com.lee.springmall.dto.ProductRequest;
import com.lee.springmall.vo.ProductVo;

import java.util.List;

public interface ProductService {

    ProductVo getById(Integer product_id);

    Integer getByNewId();

    boolean createProduct(ProductRequest productRequest);

    void updateProduct(Integer product_id, ProductRequest productRequest);

    void deleteProduct(Integer product_id);

    List<ProductVo> queryProductList(ProductQueryParams params);

    List<ProductVo> queryAll();

    Integer countProduct(ProductQueryParams params);

}
