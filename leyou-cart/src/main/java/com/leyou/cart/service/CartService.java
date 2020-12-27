package com.leyou.cart.service;

import com.leyou.auth.entity.UserInfo;
import com.leyou.cart.client.GoodsClient;
import com.leyou.cart.interceptor.LoginInterceptor;
import com.leyou.cart.pojo.Cart;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.pojo.Sku;
import com.leyou.utils.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: hasee
 * @Date: 2020/11/28
 * @Description: com.leyou.cart.service
 * @version: 1.0
 */
@Service
public class CartService {
    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    private static final String KEY_PREFIX = "leyou:cart:uid:";
    @Autowired
    private GoodsClient goodsClient;

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void addCart(Cart cart) {
        UserInfo user = LoginInterceptor.getLoginUser();
        String key = KEY_PREFIX + user.getId();
        BoundHashOperations<String, Object, Object> hashOps = redisTemplate.boundHashOps(key);
        Long skuId = cart.getSkuId();
        Integer num = cart.getNum();
        Boolean boo = hashOps.hasKey(skuId.toString());
        if (boo) {
            String json = hashOps.get(skuId.toString()).toString();
            cart = JsonUtils.parse(json,Cart.class);
            cart.setNum(cart.getNum() + num);
        } else {
            cart.setUserId(user.getId());
            Sku sku = goodsClient.querySkuById(skuId);
            cart.setImage(StringUtils.isBlank(sku.getImages()) ? "" : StringUtils.split(sku.getImages(),",")[0]);
            cart.setPrice(sku.getPrice());
            cart.setTitle(sku.getTitle());
            cart.setOwnSpec(sku.getOwnSpec());
        }
        hashOps.put(cart.getSkuId().toString(),JsonUtils.serialize(cart));



    }

    public List<Cart> queryCartList() {
        String key = KEY_PREFIX + LoginInterceptor.getLoginUser();
        if (!redisTemplate.hasKey(key)) {
            return null;
        }
        BoundHashOperations<String, Object, Object> hashOperations = redisTemplate.boundHashOps(key);
        List<Object> carts = hashOperations.values();
        if (CollectionUtils.isEmpty(carts)) {
            return null;
        }
        return carts.stream().map(cart -> JsonUtils.parse(cart.toString(),Cart.class)).collect(Collectors.toList());
    }

    public void updateCart(Cart cart) {
        String key = KEY_PREFIX + LoginInterceptor.getLoginUser();
        BoundHashOperations<String, Object, Object> hashOperations = redisTemplate.boundHashOps(key);
        Long skuId = cart.getSkuId();
        String cartJson = hashOperations.get(skuId.toString()).toString();
        Cart cart1 = JsonUtils.parse(cartJson, Cart.class);
        cart1.setNum(cart.getNum());
        hashOperations.put(skuId.toString(),JsonUtils.serialize(cart1));

    }

    public void deleteCart(String skuId) {
        String key = KEY_PREFIX + LoginInterceptor.getLoginUser();
        BoundHashOperations<String, Object, Object> hashOperations = redisTemplate.boundHashOps(key);
        hashOperations.delete(skuId);
    }
}
