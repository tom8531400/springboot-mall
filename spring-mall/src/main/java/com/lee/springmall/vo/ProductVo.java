package com.lee.springmall.vo;

import lombok.Data;

import java.util.Date;
@Data
public class ProductVo {
    private Integer product_id;
    private String product_name;
    private String category;
    private String image_url;
    private Integer price;
    private Integer stock;
    private String description;
    private Date createdDate;
    private Date lastModifiedDate;

    public ProductVo() {
    }

    public ProductVo(String product_name, String category, String image_url, Integer price, Integer stock, String description, Date createdDate, Date lastModifiedDate) {
        this.product_name = product_name;
        this.category = category;
        this.image_url = image_url;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }
}
