package com.lee.springmall.dto;

import com.lee.springmall.constant.ProductCategory;
import lombok.Data;

@Data
public class ProductQueryParams {
    private ProductCategory category;
    private String search;
    private String orderBy;
    private String shot;
    private Integer limit;
    private Integer offset;

    public ProductQueryParams() {
    }

    public ProductQueryParams(ProductCategory category, String search, String orderBy, String shot, Integer limit, Integer offset) {
        this.category = category;
        this.search = search;
        this.orderBy = orderBy;
        this.shot = shot;
        this.limit = limit;
        this.offset = offset;
    }
}
