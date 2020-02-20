package com.better.cloud.server.test.service;

import com.better.cloud.common.constant.BetterServerConstant;
import com.better.cloud.server.test.service.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lius
 * @description
 * @date 2020/2/20
 */
@FeignClient(value = BetterServerConstant.BETTER_SERVER_UPMS, contextId = "helloServiceClient", fallbackFactory = HelloServiceFallback.class)
public interface IHelloService {

    @GetMapping("hello")
    String hello(@RequestParam("name") String name);
}
