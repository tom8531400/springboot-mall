package com.lee.springmall.dao;

import com.lee.springmall.vo.OrderItem;
import com.lee.springmall.vo.OrderVo;
import org.apache.ibatis.annotations.*;

/**
 * OrderMapper
 */
@Mapper
public interface OrderMapper {
    // 新增會員訂單
    @Insert("insert into `order` (user_id, total_amount) values (#{user_id}, #{totalAmount})")
    @Options(useGeneratedKeys = true, keyProperty = "order.order_id")
    Integer createOrder(@Param("user_id") Integer user_id, @Param("totalAmount") Integer totalAmount,@Param("order") OrderVo order);
    // 新增訂單品項明細
    @Insert("insert into order_item(order_id,product_id,quantity,amount)values(#{orderId},#{orderItemList.product_id},#{orderItemList.quantity},#{orderItemList.amount})")
    void createOrderItem(@Param("orderId") Integer orderId, @Param("orderItemList") OrderItem orderItemList);

}