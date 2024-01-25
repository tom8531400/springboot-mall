package com.lee.springmall.uill;

import lombok.Data;

import java.util.List;
@Data
public class Page<T> {
    private Integer limit;
    private Integer offset;
    private Integer total;
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
