package com.better.cloud.auth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lius
 * @description Auth相关配置聚合
 * @date 2020/2/20
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:better-auth.properties"})
@ConfigurationProperties(prefix = "better.auth")
public class BetterAuthProperties {
    private BetterClientsProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;

    // 免认证路径
    private String anonUrl;

    //验证码配置类
    private BetterValidateCodeProperties code = new BetterValidateCodeProperties();
}
