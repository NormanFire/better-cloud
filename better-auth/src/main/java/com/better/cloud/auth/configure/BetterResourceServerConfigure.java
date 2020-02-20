package com.better.cloud.auth.configure;

import com.better.cloud.auth.properties.BetterAuthProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @description 资源服务器处理请求配置 对所有请求都生效 在filterChain中Order为3
 * @author lius
 * @date 2020/2/20
 */
@Configuration
@EnableResourceServer
public class BetterResourceServerConfigure extends ResourceServerConfigurerAdapter {
    @Autowired
    private BetterAuthProperties properties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUrl(), ",");
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers("/**").authenticated()
                .and().httpBasic();
    }
}
