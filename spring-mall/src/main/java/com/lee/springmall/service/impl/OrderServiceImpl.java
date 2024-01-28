package com.lee.springmall.service.impl;

import com.lee.springmall.dao.OrderMapper;
import com.lee.springmall.dao.ProductMapper;
import com.lee.springmall.dto.BuyItem;
import com.lee.springmall.dto.CreateOrderRequest;
import com.lee.springmall.dto.OrderItemAndProduct;
import com.lee.springmall.service.OrderService;
import com.lee.springmall.vo.OrderItem;
import com.lee.springmall.vo.OrderVo;
import com.lee.springmall.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * OrderServiceImpl實作抽象類
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;

    /**
     * 新增訂單
     *
     * @param userId             會員編號
     * @param createOrderRequest 訂單封裝檔
     * @param orderVo            會員訂單資訊
     * @return 最新一筆訂單編號
     */
    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest, OrderVo orderVo) {
        // 總金額預設為0
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();
        // 把json打包檔解開複製給buyItem，獲取每一筆訂單資訊
        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            // 透過商品id，獲取商品的資訊
            ProductVo productVo = productMapper.getById(buyItem.getProductId());
            // 將商品個數和價格乘起來，加總起來totalAmount
            int amount = buyItem.getQuantity() * productVo.getPrice();
            totalAmount += amount;

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct_id(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);
            orderItemList.add(orderItem);

        }
        // 創建OrderVo接收mapper回傳id值
        OrderVo order = new OrderVo();
        orderMapper.createOrder(userId, totalAmount, order);
        // 取出mapper回傳id值
        Integer orderId = order.getOrder_id();
        for (OrderItem data : orderItemList) {
            orderMapper.createOrderItem(orderId, data);
        }
        return orderId;
    }

    /**
     * 透過orederID獲取會員訂單資訊
     * @param orderId 訂單編號
     * @return 訂單資訊
     */
    @Override
    public OrderVo getByOrderId(Integer orderId) {
        // 獲取會員訂單
        OrderVo order = orderMapper.getByOrderId(orderId);
        // 獲取訂單資訊
        List<OrderItemAndProduct> OrderItemAndProduct = orderMapper.getOrderItemByOrderId(orderId);
        order.setOrderItemList(OrderItemAndProduct);

        return order;
    }
}
