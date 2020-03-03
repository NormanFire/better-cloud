package com.better.cloud.server.wiki;

import com.better.cloud.common.annotation.BetterCloudApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author lius
 * @description
 * @date 2020/2/28
 */
@BetterCloudApplication
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@MapperScan("com.better.cloud.server.wiki.mapper")
public class BetterServerWikiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BetterServerWikiApplication.class,args);
    }
}
