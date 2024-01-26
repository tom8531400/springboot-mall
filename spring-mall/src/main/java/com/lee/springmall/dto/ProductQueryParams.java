package com.lee.springmall.dto;

import com.lee.springmall.constant.ProductCategory;
import lombok.Data;

/**
 * 分頁查詢封裝物件
 */
@Data
public class ProductQueryParams {
    // 商品種類
    private ProductCategory category;
    // 關鍵字
    private String search;
    // 排序種類
    private String orderBy;
    // 升序or降序
    private String shot;
    // 查詢筆數
    private Integer limit;
    // 從第幾筆開始查詢
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
