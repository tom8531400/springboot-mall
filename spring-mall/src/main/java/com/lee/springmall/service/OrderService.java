package com.lee.springmall.service;

import com.lee.springmall.dto.CreateOrderRequest;
import com.lee.springmall.vo.OrderVo;

/**
 * OrderService抽象類
 */
public interface OrderService {
    // 新增訂單(返回訂單編號)
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest, OrderVo order);

    // 透過orederID獲取會員訂單資訊
    OrderVo getByOrderId(Integer orderId);
}
