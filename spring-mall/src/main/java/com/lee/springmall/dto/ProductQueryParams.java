package com.lee.springmall.dto;

import com.lee.springmall.constant.ProductCategory;
import lombok.Data;

@Data
public class ProductQueryParams {
    private ProductCategory category;
    private String search;

    public ProductQueryParams() {
    }

    public ProductQueryParams(ProductCategory category, String search) {
        this.category = category;
        this.search = search;
    }

}
