package com.lee.springmall.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BuyItem {
    @NotNull
    private Integer productId;
    @NotNull
    private Integer quantity;

    public BuyItem() {
    }

    public BuyItem(Integer productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
