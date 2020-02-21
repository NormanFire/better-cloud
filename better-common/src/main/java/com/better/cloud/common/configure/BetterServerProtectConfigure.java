package com.better.cloud.common.configure;

import com.better.cloud.common.interceptor.BetterServerProtectInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lius
 * @description
 * @date 2020/2/21
 */
public class BetterServerProtectConfigure implements WebMvcConfigurer {

    @Bean
    @ConditionalOnMissingBean(value = PasswordEncoder.class) //微服务可以自定义PasswordEncoder
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HandlerInterceptor betterServerProtectInterceptor() {
        return new BetterServerProtectInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(betterServerProtectInterceptor());
    }
}

