package com.better.cloud.auth;

import com.better.cloud.common.annotation.enable.EnableBetterAuthExceptionHandler;
import com.better.cloud.common.annotation.enable.EnableBetterLettuceRedis;
import com.better.cloud.common.annotation.enable.EnableBetterServerProtect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableBetterAuthExceptionHandler
@EnableBetterServerProtect
@EnableBetterLettuceRedis
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.better.cloud.auth.mapper")
public class BetterAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(BetterAuthApplication.class,args);
    }
}
