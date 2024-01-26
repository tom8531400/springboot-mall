package com.lee.springmall.uill;

import lombok.Data;

import java.util.List;

/**
 * 分頁查詢類
 * @param <T> 查詢參數
 */
@Data
public class Page<T> {
    // 查詢筆數
    private Integer limit;
    // 從第幾筆開始查詢
    private Integer offset;
    // 總共筆數
    private Integer total;
    // 自訂義查詢資料
    private List<T> result;

    public Page() {
    }

    public Page(Integer limit, Integer offset, Integer total, List<T> result) {
        this.limit = limit;
        this.offset = offset;
        this.total = total;
        this.result = result;
    }
}
