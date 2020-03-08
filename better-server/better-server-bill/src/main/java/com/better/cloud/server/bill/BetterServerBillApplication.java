package com.better.cloud.server.bill;

import com.better.cloud.common.annotation.BetterCloudApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lius
 * @description
 * @date 2020/3/8
 */
@BetterCloudApplication
@EnableFeignClients
@EnableTransactionManagement
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启Spring Cloud Security权限注解
@MapperScan("com.better.cloud.server.bill.mapper")
public class BetterServerBillApplication {
    public static void main(String[] args) {
        SpringApplication.run(BetterServerBillApplication.class,args);
    }
}
