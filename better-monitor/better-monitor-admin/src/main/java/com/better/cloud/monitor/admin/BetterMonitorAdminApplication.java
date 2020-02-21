package com.better.cloud.monitor.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lius
 * @description
 * @date 2020/2/21
 */
@EnableAdminServer
@SpringBootApplication
public class BetterMonitorAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(BetterMonitorAdminApplication.class, args);
    }
}
