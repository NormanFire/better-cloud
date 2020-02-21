package com.better.cloud.common.configure;

import com.better.cloud.common.handler.BetterAccessDeniedHandler;
import com.better.cloud.common.handler.BetterAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author lius
 * @description 注入异常处理 使用ConditionalOnMissingBean方便微服务自定义异常处理
 * @date 2020/2/21
 */
public class BetterAuthExceptionConfigure {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public BetterAccessDeniedHandler accessDeniedHandler() {
        return new BetterAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public BetterAuthExceptionEntryPoint authenticationEntryPoint() {
        return new BetterAuthExceptionEntryPoint();
    }
}

