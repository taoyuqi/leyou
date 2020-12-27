package com.leyou.search.pojo;

import com.leyou.item.pojo.Brand;

import java.util.List;
import java.util.Map;

/**
 * @Auther: hasee
 * @Date: 2020/11/18
 * @Description: com.leyou.search.pojo
 * @version: 1.0
 */
public class SearchRequest {
    private String key;// 搜索条件

    private Integer page;// 当前页

    private List<Map<String, Object>> categories;

    private List<Brand> brands;

    private static final Integer DEFAULT_SIZE = 20;// 每页大小，不从页面接收，而是固定大小
    private static final Integer DEFAULT_PAGE = 1;// 默认页

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getPage() {
        if (page == null) {
            return DEFAULT_PAGE;
        }
        // 获取页码时做一些校验，不能小于1
        return Math.max(DEFAULT_PAGE, page);
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return DEFAULT_SIZE;
    }

    public List<Map<String, Object>> getCategories() {
        return categories;
    }

    public void setCategories(List<Map<String, Object>> categories) {
        this.categories = categories;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }
}
