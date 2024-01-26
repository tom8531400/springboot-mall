package com.lee.springmall.dao;

import com.lee.springmall.dto.ProductQueryParams;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 自訂義查詢SQL
 */
public class ProductProvider {

    public String selectProducts(@Param("params") ProductQueryParams params) {
        return new SQL() {{
            SELECT("*");
            FROM("product");
            WHERE("product_name LIKE CONCAT('%', #{params.search}, '%')");
            if (params.getCategory() != null) {
                AND().WHERE("category = #{params.category}");
            }
            ORDER_BY("${params.orderBy} ${params.shot}");
            LIMIT("${params.limit}");
            OFFSET("${params.offset}");
        }}.toString();
    }
}
