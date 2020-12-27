package com.leyou.order.utils;

import com.github.wxpay.sdk.WXPay;
import com.leyou.order.config.PayConfig;
import com.leyou.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Auther: hasee
 * @Date: 2020/11/29
 * @Description: com.leyou.order.utils
 * @version: 1.0
 */
@Component
public class PayHelper {
    private static final Logger logger = LoggerFactory.getLogger(PayHelper.class);
    private WXPay wxPay;

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Autowired
//    private OrderService orderService;
//
//    public PayHelper(PayConfig payConfig) {
//
//    }
}
