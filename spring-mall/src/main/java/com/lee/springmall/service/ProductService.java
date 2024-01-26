package com.lee.springmall.service;

import com.lee.springmall.dto.ProductQueryParams;
import com.lee.springmall.dto.ProductRequest;
import com.lee.springmall.vo.ProductVo;

import java.util.List;

/**
 * ProductService 抽象類
 */

public interface ProductService {
    // 依照product_id查詢商品
    ProductVo getById(Integer product_id);
    // 查詢最新一筆資料
    Integer getByNewId();
    // 新增商品資料
    boolean createProduct(ProductRequest productRequest);
    // 更新商品資料
    void updateProduct(Integer product_id, ProductRequest productRequest);
    // 刪除商品資料
    void deleteProduct(Integer product_id);
    // 自訂義查詢商品資料
    List<ProductVo> queryProductList(ProductQueryParams params);
    // 查詢全部商品資料
    List<ProductVo> queryAll();
    // 查詢自訂義商品種類總筆數
    Integer countProduct(ProductQueryParams params);

}
