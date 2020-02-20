package com.better.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author lius
 * @description 网关服务
 * @date 2020/2/20
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class BetterGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BetterGatewayApplication.class, args);
    }
}
