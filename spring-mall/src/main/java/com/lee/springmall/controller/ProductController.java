package com.lee.springmall.controller;

import com.lee.springmall.dto.ProductRequest;
import com.lee.springmall.service.ProductService;
import com.lee.springmall.vo.ProductVo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public ResponseEntity<ProductVo> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        boolean productId = productService.createProduct(productRequest);
        if (productId) {
            Integer newId = productService.getByNewId();
            ProductVo productVo = productService.getById(newId);
            return ResponseEntity.status(HttpStatus.OK).body(productVo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
