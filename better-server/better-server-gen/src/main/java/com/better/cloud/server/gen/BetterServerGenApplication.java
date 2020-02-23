package com.better.cloud.server.gen;

import com.better.cloud.common.annotation.BetterCloudApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启Spring Cloud Security权限注解
@MapperScan("com.better.cloud.server.gen.mapper")
public class BetterServerGenApplication {
    public static void main(String[] args) {
        SpringApplication.run(BetterServerGenApplication.class, args);
    }
}
