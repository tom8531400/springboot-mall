package com.lee.springmall.controller;

import com.lee.springmall.constant.ProductCategory;
import com.lee.springmall.dto.ProductQueryParams;
import com.lee.springmall.dto.ProductRequest;
import com.lee.springmall.service.ProductService;
import com.lee.springmall.uill.Page;
import com.lee.springmall.vo.ProductVo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ProductController商品控制項
 */

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 透過 product_id 查詢商品方法
     *
     * @param product_id 商品編號
     * @return 查詢的商品資訊
     */
    @RequestMapping(value = "/getById/{product_id}", method = RequestMethod.GET)
    public ResponseEntity<ProductVo> getById(@PathVariable Integer product_id) {
        ProductVo productVo = productService.getById(product_id);
        if (productVo != null) {
            return ResponseEntity.status(HttpStatus.OK).body(productVo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * 新增商品方法
     *
     * @param productRequest 新增商品自訂欄位
     * @return 新增後的商品資訊
     */
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

    /**
     * 商品修改方法
     *
     * @param product_id     商品編號
     * @param productRequest 要修改的商品資訊
     * @return 修改完的商品資訊
     */
    @RequestMapping(value = "/updateProduct/{product_id}", method = RequestMethod.PUT)
    public ResponseEntity<ProductVo> updateProduct(@PathVariable Integer product_id,
                                                   @RequestBody @Valid ProductRequest productRequest) {
        if (productService.getById(product_id) != null) {
            productService.updateProduct(product_id, productRequest);
            ProductVo updateProductVo = productService.getById(product_id);
            return ResponseEntity.status(HttpStatus.OK).body(updateProductVo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * 刪除商品方法
     *
     * @param product_id 商品編號
     * @return 成功與否
     */
    @RequestMapping(value = "/deleteProduct/{product_id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable Integer product_id) {
        productService.deleteProduct(product_id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 查詢全部列表資訊
     *
     * @return 全部列表資訊
     */
    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    public ResponseEntity<List<ProductVo>> queryAll() {
        List<ProductVo> queryAll = productService.queryAll();
        return ResponseEntity.status(HttpStatus.OK).body(queryAll);
    }


    /**
     * 自定義查詢列表
     *
     * @param category 商品種類
     * @param search   查詢關鍵字
     * @param orderBy  排序依據
     * @param shot     正排序還是倒排序
     * @return 自定義查詢列表資訊
     */
    @Validated
    @RequestMapping(value = "/queryProductList", method = RequestMethod.GET)
    public ResponseEntity<Page<ProductVo>> queryProductVoList(@RequestParam(required = false) ProductCategory category,
                                                              @RequestParam(defaultValue = "") String search,
                                                              @RequestParam(defaultValue = "created_date") String orderBy,
                                                              @RequestParam(defaultValue = "desc") String shot,
                                                              @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
                                                              @RequestParam(defaultValue = "0") @Min(0) Integer offset) {
        ProductQueryParams params = new ProductQueryParams();
        params.setCategory(category);
        params.setSearch(search);
        params.setOrderBy(orderBy);
        params.setShot(shot);
        params.setLimit(limit);
        params.setOffset(offset);
        List<ProductVo> queryProductList = productService.queryProductList(params);
        Integer total = productService.countProduct(params);

        Page<ProductVo> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResult(queryProductList);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

}
