package com.leyou.search.pojo;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;

import java.util.List;
import java.util.Map;

/**
 * @Auther: hasee
 * @Date: 2020/11/18
 * @Description: com.leyou.search.pojo
 * @version: 1.0
 */
public class SearchResult<Goods> extends PageResult<Goods> {
    private List<Map<String, Object>> categories;
    private List<Brand> brands;
    public SearchResult() {
    }

    public SearchResult(List<Map<String, Object>> categories, List<Brand> brands) {
        this.categories = categories;
        this.brands = brands;
    }

    public SearchResult(List<Goods> items, Long total, List<Map<String, Object>> categories, List<Brand> brands) {
        super(total, items);
        this.categories = categories;
        this.brands = brands;
    }

    public SearchResult(List<Goods> items, Long total, Integer totalPage, List<Map<String, Object>> categories, List<Brand> brands) {
        super(total, totalPage,items);
        this.categories = categories;
        this.brands = brands;
    }
}
