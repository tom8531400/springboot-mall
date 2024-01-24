package com.lee.springmall.dao;

import com.lee.springmall.dto.ProductRequest;
import com.lee.springmall.vo.ProductVo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductMapper {

    @Select("select * from product where product_id = #{product_id}")
    ProductVo getById(@Param("product_id") Integer product_id);

    @Select("select MAX(product_id) from product")
    Integer getByNewId();

    @Insert("insert into product(product_name,category,image_url,price,stock,description)values" +
            "(#{productRequest.product_name},#{productRequest.category},#{productRequest.image_url}," +
            "#{productRequest.price},#{productRequest.stock},#{productRequest.description})")
    boolean createProduct(@Param("productRequest") ProductRequest productRequest);

    @Update("update product set product_name = #{productRequest.product_name},category = #{productRequest.category}," +
            "image_url = #{productRequest.image_url}, price = #{productRequest.price}, stock = #{productRequest.stock}," +
            "description = #{productRequest.description} where product_id = #{product_id}")
    void updateProduct(@Param("product_id") Integer product_id,@Param("productRequest") ProductRequest productRequest);

}
