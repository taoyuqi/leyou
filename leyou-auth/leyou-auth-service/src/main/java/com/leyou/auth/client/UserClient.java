package com.leyou.auth.client;

import com.leyou.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: hasee
 * @Date: 2020/11/23
 * @Description: com.leyou.auth
 * @version: 1.0
 */
@FeignClient("user-service")
public interface UserClient extends UserApi {
}
