package com.lee.springmall.controller;

import com.lee.springmall.dto.CreateOrderRequest;
import com.lee.springmall.service.OrderService;
import com.lee.springmall.vo.OrderVo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * OrderController訂單控制項
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 新增訂單
     * @param userId 會員編號
     * @param createOrderRequest 訂單封裝物件
     * @return 最新一筆訂單編號
     */
    @RequestMapping(value = "/users/{userId}/order", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest) {
        // 創建訂單物件獲取最新一筆訂單編號
        OrderVo orderVo = new OrderVo();
        Integer createOrder = orderService.createOrder(userId, createOrderRequest, orderVo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createOrder);
    }
}
