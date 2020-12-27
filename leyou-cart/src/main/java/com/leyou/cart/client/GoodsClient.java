package com.leyou.cart.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: hasee
 * @Date: 2020/11/28
 * @Description: com.leyou.cart.client
 * @version: 1.0
 */
@FeignClient(value = "item-service")
public interface GoodsClient extends GoodsApi {
}
