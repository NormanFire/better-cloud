package com.better.cloud.server.upms;

import com.better.cloud.common.annotation.BetterCloudApplication;
import com.better.cloud.common.annotation.enable.EnableBetterAuthExceptionHandler;
import com.better.cloud.common.annotation.enable.EnableBetterOauth2FeignClient;
import com.better.cloud.common.annotation.enable.EnableBetterServerProtect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lius
 * @description 通用用户权限管理系统微服务
 * @date 2020/2/20
 */
@BetterCloudApplication
@EnableFeignClients
@EnableTransactionManagement
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启Spring Cloud Security权限注解
@MapperScan("com.better.cloud.server.upms.mapper")
public class BetterServerUPMSApplication {
    public static void main(String[] args) {
        SpringApplication.run(BetterServerUPMSApplication.class, args);
    }
}
