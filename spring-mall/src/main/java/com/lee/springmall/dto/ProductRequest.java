package com.lee.springmall.dto;

import com.lee.springmall.constant.ProductCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 新增商品封裝物件
 */
@Data
public class ProductRequest {
    // 商品名稱
    @NotNull
    private String product_name;
    // 商品種類
    @NotNull
    private ProductCategory category;
    // 圖片URL
    @NotNull
    private String image_url;
    // 商品價格
    @NotNull
    private Integer price;
    // 商品庫存
    @NotNull
    private Integer stock;
    // 商品簡介
    private String description;

    public ProductRequest() {
    }

    public ProductRequest(String product_name, ProductCategory category, String image_url, Integer price, Integer stock) {
        this.product_name = product_name;
        this.category = category;
        this.image_url = image_url;
        this.price = price;
        this.stock = stock;
    }

    public ProductRequest(String product_name, ProductCategory category, String image_url, Integer price, Integer stock, String description) {
        this.product_name = product_name;
        this.category = category;
        this.image_url = image_url;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }
}
