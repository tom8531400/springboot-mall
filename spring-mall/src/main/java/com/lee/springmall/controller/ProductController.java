package com.lee.springmall.controller;

import com.lee.springmall.service.ProductService;
import com.lee.springmall.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/getById/{product_id}", method = RequestMethod.GET)
    public ResponseEntity<ProductVo> getById(@PathVariable Integer product_id) {
        ProductVo productVo = productService.getById(product_id);
        if (productVo != null) {
            return ResponseEntity.status(HttpStatus.OK).body(productVo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
