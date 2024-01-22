package com.lee.springmall.vo;

import com.lee.springmall.constant.ProductCategory;
import lombok.Data;

import java.util.Date;

@Data
public class ProductVo {
    private Integer product_id;
    private String product_name;
    // 商品分類
    private ProductCategory category;
    private String image_url;
    private Integer price;
    private Integer stock;
    private String description;
    private Date created_date;
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
