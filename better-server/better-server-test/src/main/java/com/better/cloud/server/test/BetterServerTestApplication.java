package com.better.cloud.server.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author lius
 * @description
 * @date 2020/2/20
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BetterServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BetterServerTestApplication.class, args);
    }
}
