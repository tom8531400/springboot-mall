package com.lee.springmall.vo;

import lombok.Data;

/**
 * 訂單下訂資訊
 * 建表日期 112/01/27
 */
@Data
public class OrderItem {
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

    public OrderItem() {
    }

    public OrderItem(Integer order_item_id, Integer order_id, Integer product_id, Integer quantity, Integer amount) {
        this.order_item_id = order_item_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.amount = amount;
    }
}
