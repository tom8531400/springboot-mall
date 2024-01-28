package com.lee.springmall.vo;

import com.lee.springmall.dto.OrderItemAndProduct;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 會員訂單資訊
 * 建表日期 112/01/27
 */
@Data
public class OrderVo {
    // 訂單編號
    private Integer order_id;
    // 會員編號
    private Integer user_id;
    // 訂單總額
    private Integer total_amount;
    // 建立日期
    private Date created_date;
    // 最後修改日期
    private Date lastModified_date;
    // 商品訂單明細
    private List<OrderItemAndProduct> orderItemList;

    public OrderVo() {
    }

    public OrderVo(Integer order_id, Integer user_id, Integer total_amount, Date created_date, Date lastModified_date, List<OrderItemAndProduct> orderItemList) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.total_amount = total_amount;
        this.created_date = created_date;
        this.lastModified_date = lastModified_date;
        this.orderItemList = orderItemList;
    }
}
