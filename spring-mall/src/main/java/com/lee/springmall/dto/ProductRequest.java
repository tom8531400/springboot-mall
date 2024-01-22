package com.lee.springmall.dto;

import com.lee.springmall.constant.ProductCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {
    @NotNull
    private String product_name;
    @NotNull
    private ProductCategory category;
    @NotNull
    private String image_url;
    @NotNull
    private Integer price;
    @NotNull
    private Integer stock;
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
