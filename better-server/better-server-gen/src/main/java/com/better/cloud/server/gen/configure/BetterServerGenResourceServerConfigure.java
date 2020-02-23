package com.better.cloud.server.gen.configure;

import com.better.cloud.common.handler.BetterAccessDeniedHandler;
import com.better.cloud.common.handler.BetterAuthExceptionEntryPoint;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author lius
 * @description 资源服务器安全配置
 * @date 2020/2/20
 */
@Configuration
@EnableResourceServer
public class BetterServerGenResourceServerConfigure extends ResourceServerConfigurerAdapter {
    @Autowired
    private BetterAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private BetterAuthExceptionEntryPoint exceptionEntryPoint;
//    @Autowired
//    private BetterServerUPMSProperties properties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUrl(), ",");
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens("", ",");
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/**").authenticated();
    }
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
