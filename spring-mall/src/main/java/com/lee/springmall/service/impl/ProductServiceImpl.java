package com.lee.springmall.service.impl;

import com.lee.springmall.dao.ProductMapper;
import com.lee.springmall.dto.ProductQueryParams;
import com.lee.springmall.dto.ProductRequest;
import com.lee.springmall.service.ProductService;
import com.lee.springmall.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductServiceImpl 實作抽象類
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    /**
     * 依照product_id查詢商品
     *
     * @param product_id 商品編號
     * @return ProductVo
     */
    @Override
    public ProductVo getById(Integer product_id) {
        return productMapper.getById(product_id);
    }

    /**
     * 查詢最新一筆資料
     *
     * @return 最新筆數編號
     */
    @Override
    public Integer getByNewId() {
        return productMapper.getByNewId();
    }

    /**
     * 新增商品資料
     *
     * @param productRequest Request商品資料
     * @return 是否新增成功
     */
    @Override
    public boolean createProduct(ProductRequest productRequest) {
        return productMapper.createProduct(productRequest);
    }

    /**
     * 更新商品資料
     *
     * @param product_id     商品編號
     * @param productRequest Request商品資料
     */
    @Override
    public void updateProduct(Integer product_id, ProductRequest productRequest) {
        productMapper.updateProduct(product_id, productRequest);
    }

    /**
     * 刪除商品資料
     *
     * @param product_id 商品編號
     */
    @Override
    public void deleteProduct(Integer product_id) {
        productMapper.deleteProduct(product_id);
    }

    /**
     * 自訂義查詢商品資料
     *
     * @param params ProductQueryParams 自訂義查詢資料
     * @return 回傳查詢結果
     */
    @Override
    public List<ProductVo> queryProductList(ProductQueryParams params) {
        return productMapper.queryProductNotNull(params);
    }

    /**
     * 查詢全部商品資料
     *
     * @return 回傳查詢結果
     */
    @Override
    public List<ProductVo> queryAll() {
        return productMapper.queryAll();
    }

    /**
     * 查詢自訂義商品種類總筆數
     *
     * @param params ProductQueryParams 自訂義查詢資料
     * @return 回傳查詢筆數
     */
    @Override
    public Integer countProduct(ProductQueryParams params) {
        return productMapper.countProduct(params);
    }


}
