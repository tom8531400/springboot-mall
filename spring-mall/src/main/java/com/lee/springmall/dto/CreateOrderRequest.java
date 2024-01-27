package com.lee.springmall.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;
@Data
public class CreateOrderRequest {
    @NotEmpty
    private List<BuyItem> buyItemList;

    public CreateOrderRequest() {
    }

    public CreateOrderRequest(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
    }
}
