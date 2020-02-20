package com.better.cloud.auth.properties;

import lombok.Data;

/**
 * @author lius
 * @description Oauth2相关配置聚合
 * @date 2020/2/20
 */
@Data
public class BetterClientsProperties {
    private String client;
    private String secret;
    private String grantType = "password,authorization_code,refresh_token";
    private String scope = "all";
}
