package com.better.cloud.server.mq;

import com.better.cloud.common.annotation.BetterCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author: Mou Yiquan
 * @create: 2020/3/8 10:50
 * @description:
 **/
@BetterCloudApplication
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BetterServerMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(BetterServerMQApplication.class,args);
    }
}
