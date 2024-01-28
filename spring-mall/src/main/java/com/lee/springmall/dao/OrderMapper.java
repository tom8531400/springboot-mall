package com.lee.springmall.dao;

import com.lee.springmall.dto.OrderItemAndProduct;
import com.lee.springmall.vo.OrderItem;
import com.lee.springmall.vo.OrderVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * OrderMapper
 */
@Mapper
public interface OrderMapper {
    // 新增會員訂單
    @Insert("insert into `order` (user_id, total_amount) values (#{user_id}, #{totalAmount})")
    @Options(useGeneratedKeys = true, keyProperty = "order.order_id")
    Integer createOrder(@Param("user_id") Integer user_id, @Param("totalAmount") Integer totalAmount, @Param("order") OrderVo order);

    // 新增訂單品項明細
    @Insert("insert into order_item(order_id,product_id,quantity,amount)values(#{orderId},#{orderItemList.product_id},#{orderItemList.quantity},#{orderItemList.amount})")
    void createOrderItem(@Param("orderId") Integer orderId, @Param("orderItemList") OrderItem orderItemList);

    // 依照order_id查詢order資訊
    @Select("select * from `order` where order_id = #{orderId}")
    OrderVo getByOrderId(@Param("orderId") Integer orderId);

    // 把查到的會員訂單資訊和訂單細部內容合在一起回傳給前端
    @Select("select ot.order_item_id,ot.order_id,ot.product_id,ot.quantity,ot.amount,p.product_name,p.image_url " +
            "from order_item as ot " +
            "left join product as p " +
            "on ot.product_id = p.product_id " +
            "where ot.order_id = #{orderId}")
    List<OrderItemAndProduct> getOrderItemByOrderId(@Param("orderId") Integer orderId);

}