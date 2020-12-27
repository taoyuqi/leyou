package com.leyou.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: hasee
 * @Date: 2020/11/29
 * @Description: com.leyou.order
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LeyouOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeyouOrderApplication.class,args);
    }
}
