package com.lee.springmall.dto;

import lombok.Data;

@Data
public class OrderItemAndProduct {
    // 訂單下訂編號
    private Integer order_item_id;
    // 訂單編號
    private Integer order_id;
    // 商品編號
    private Integer product_id;
    // 商品總數
    private Integer quantity;
    // 商品總額
    private Integer amount;
    // 商品名稱
    private String product_name;
    // 圖片URL
    private String image_url;

    public OrderItemAndProduct() {
    }

    public OrderItemAndProduct(Integer order_item_id, Integer order_id, Integer product_id, Integer quantity, Integer amount, String product_name, String image_url) {
        this.order_item_id = order_item_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.amount = amount;
        this.product_name = product_name;
        this.image_url = image_url;
    }
}
