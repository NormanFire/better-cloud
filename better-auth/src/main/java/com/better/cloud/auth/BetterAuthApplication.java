package com.better.cloud.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.better.cloud.auth.mapper")
public class BetterAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(BetterAuthApplication.class,args);
    }
}
