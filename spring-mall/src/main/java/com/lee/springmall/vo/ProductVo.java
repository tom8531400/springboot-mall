package com.lee.springmall.vo;

import com.lee.springmall.constant.ProductCategory;
import lombok.Data;

import java.util.Date;

/**
 * 商品基本資料
 * 建表日期 112/01/26
 */

@Data
public class ProductVo {
    // 商品編號
    private Integer product_id;
    // 商品名稱
    private String product_name;
    // 商品種類
    private ProductCategory category;
    // 圖片URL
    private String image_url;
    // 商品價錢
    private Integer price;
    // 商品庫存
    private Integer stock;
    // 商品簡介
    private String description;
    // 建立日期
    private Date created_date;
    // 最後修改日期
    private Date lastModified_date;

    public ProductVo() {
    }

    public ProductVo(String product_name, ProductCategory category, String image_url, Integer price, Integer stock, String description, Date created_date, Date lastModified_date) {
        this.product_name = product_name;
        this.category = category;
        this.image_url = image_url;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.created_date = created_date;
        this.lastModified_date = lastModified_date;
    }
}
