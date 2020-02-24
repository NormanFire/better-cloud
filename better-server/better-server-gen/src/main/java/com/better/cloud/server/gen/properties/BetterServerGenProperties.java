package com.better.cloud.server.gen.properties;

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
@PropertySource(value = {"classpath:better-server-gen.properties"})
@ConfigurationProperties(prefix = "better.server.gen")
public class BetterServerGenProperties {

    /**
     * 批量插入当批次可插入的最大值
     */
    private Integer batchInsertMaxNum = 1000;

    /**
     * 免认证 URI，多个值的话以逗号分隔
     */
    private String anonUrl;

    private SwaggerProperties swagger = new SwaggerProperties();
}
