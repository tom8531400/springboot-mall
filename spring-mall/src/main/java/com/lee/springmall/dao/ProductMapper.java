package com.lee.springmall.dao;

import com.lee.springmall.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {

    @Select("select * from product where product_id = #{product_id}")
    ProductVo getById(@Param("product_id") Integer product_id);
}
