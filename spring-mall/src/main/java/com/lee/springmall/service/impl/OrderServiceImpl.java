package com.lee.springmall.service.impl;

import com.lee.springmall.dao.OrderMapper;
import com.lee.springmall.dao.ProductMapper;
import com.lee.springmall.dao.UserMapper;
import com.lee.springmall.dto.BuyItem;
import com.lee.springmall.dto.CreateOrderRequest;
import com.lee.springmall.dto.OrderItemAndProduct;
import com.lee.springmall.service.OrderService;
import com.lee.springmall.vo.OrderItem;
import com.lee.springmall.vo.OrderVo;
import com.lee.springmall.vo.ProductVo;
import com.lee.springmall.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

/**
 * OrderServiceImpl實作抽象類
 */
@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserMapper userMapper;

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
        // 判斷前端傳進來的會員編號是否正確
        UserVo userVo = userMapper.getUserById(userId);
        if (userVo == null) {
            log.warn("您輸入的會員編號 {} 是錯誤的", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 總金額預設為0
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();
        // 把json打包檔解開複製給buyItem，獲取每一筆訂單資訊
        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            // 透過商品id，獲取商品的資訊
            ProductVo productVo = productMapper.getById(buyItem.getProductId());
            // 判斷庫存是否有足夠，不足或是庫存為0就會返回錯誤訊息
            if (productVo.getStock() == 0) {
                log.warn("您所購買的商品 {} 已經沒有庫存", productVo.getProduct_name());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            } else if (productVo.getStock() < buyItem.getQuantity()) {
                log.warn("您所要購買的數量 {} 已超過商品庫存數量 {}，請修正後再下訂", buyItem.getQuantity(), productVo.getStock());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
            // 判斷庫存足夠後，並且把庫存的數量扣掉訂單的數量，更新數據
            productMapper.updateProductStock(productVo.getProduct_id(), productVo.getStock() - buyItem.getQuantity());

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
     *
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
