package com.better.cloud.common.configure;

import com.better.cloud.common.constant.BetterConstant;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.util.Base64Utils;

/**
 * @author lius
 * @description 为feign调用添加验证信息
 * @date 2020/2/20
 */
public class BetterOAuth2FeignConfigure {
    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return requestTemplate -> {

            // 添加 Zuul Token
            String zuulToken = new String(Base64Utils.encode(BetterConstant.GATEWAY_TOKEN_VALUE.getBytes()));
            requestTemplate.header(BetterConstant.GATEWAY_TOKEN_HEADER, zuulToken);

            Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
            if (details instanceof OAuth2AuthenticationDetails) {
                String authorizationToken = ((OAuth2AuthenticationDetails) details).getTokenValue();
                requestTemplate.header(HttpHeaders.AUTHORIZATION, "bearer " + authorizationToken);
            }
        };
    }
}
