package com.lee.springmall.dto;

import com.lee.springmall.constant.ProductCategory;
import lombok.Data;

@Data
public class ProductQueryParams {
    private ProductCategory category;
    private String search;
    private String orderBy;
    private String shot;

    public ProductQueryParams() {
    }

    public ProductQueryParams(ProductCategory category, String search, String orderBy, String shot) {
        this.category = category;
        this.search = search;
        this.orderBy = orderBy;
        this.shot = shot;
    }

}
