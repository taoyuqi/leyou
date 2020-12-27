package com.leyou.search.repository;

import com.leyou.search.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Auther: hasee
 * @Date: 2020/11/17
 * @Description: com.leyou.search.repository
 * @version: 1.0
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods,Long> {
}
