package com.better.cloud.common.annotation;

import com.better.cloud.common.configure.BetterOAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lius
 * @description 开启拦截feign 为feign添加验证信息
 * @date 2020/2/20
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BetterOAuth2FeignConfigure.class)
public @interface EnableBetterOauth2FeignClient {

}
