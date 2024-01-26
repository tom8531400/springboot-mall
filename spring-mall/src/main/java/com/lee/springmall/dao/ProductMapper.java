package com.lee.springmall.dao;

import com.lee.springmall.dto.ProductQueryParams;
import com.lee.springmall.dto.ProductRequest;
import com.lee.springmall.vo.ProductVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ProductMapper
 */
@Mapper
public interface ProductMapper {
    // 依照product_id查詢商品
    @Select("select * from product where product_id = #{product_id}")
    ProductVo getById(@Param("product_id") Integer product_id);

    // 查詢最新一筆資料
    @Select("select MAX(product_id) from product")
    Integer getByNewId();

    // 新增商品資料
    @Insert("insert into product(product_name,category,image_url,price,stock,description)values" +
            "(#{productRequest.product_name},#{productRequest.category},#{productRequest.image_url}," +
            "#{productRequest.price},#{productRequest.stock},#{productRequest.description})")
    boolean createProduct(@Param("productRequest") ProductRequest productRequest);

    // 更新商品資料
    @Update("update product set product_name = #{productRequest.product_name},category = #{productRequest.category}," +
            "image_url = #{productRequest.image_url}, price = #{productRequest.price}, stock = #{productRequest.stock}," +
            "description = #{productRequest.description} where product_id = #{product_id}")
    void updateProduct(@Param("product_id") Integer product_id, @Param("productRequest") ProductRequest productRequest);

    // 刪除商品資料
    @Delete("delete from product where product_id = #{product_id}")
    void deleteProduct(@Param("product_id") Integer product_id);

    // 自訂義查詢商品資料
    @Select("select * from product")
    List<ProductVo> queryAll();

    // 查詢全部商品資料
    @SelectProvider(type = ProductProvider.class, method = "selectProducts")
    List<ProductVo> queryProductNotNull(@Param("params") ProductQueryParams params);

    // 查詢自訂義商品種類總筆數
    @Select("select count(*) from product where category = #{params.category} ")
    Integer countProduct(@Param("params") ProductQueryParams params);

}
