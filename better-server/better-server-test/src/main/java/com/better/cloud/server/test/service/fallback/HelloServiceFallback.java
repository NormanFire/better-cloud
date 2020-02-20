package com.better.cloud.server.test.service.fallback;

import com.better.cloud.server.test.service.IHelloService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author lius
 * @description
 * @date 2020/2/20
 */
@Slf4j
@Component
public class HelloServiceFallback implements FallbackFactory<IHelloService> {
    @Override
    public IHelloService create(Throwable throwable) {
        return new IHelloService() {
            @Override
            public String hello(String name) {
                log.error("调用better-server-upms服务出错", throwable);
                return "调用出错";
            }
        };
    }
}