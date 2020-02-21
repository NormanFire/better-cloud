package com.better.cloud.gateway.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lius
 * @description
 * @date 2020/2/21
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:better-gateway.properties"})
@ConfigurationProperties(prefix = "better.gateway")
public class BetterGatewayProperties {
    /**
     * 禁止外部访问的 URI，多个值的话以逗号分隔
     */
    private String forbidRequestUri;
}
