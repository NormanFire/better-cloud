package com.better.cloud.server.upms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author lius
 * @description 通用用户权限管理系统微服务
 * @date 2020/2/20
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启Spring Cloud Security权限注解
public class BetterServerUPMSApplication {
    public static void main(String[] args) {
        SpringApplication.run(BetterServerUPMSApplication.class, args);
    }
}
