package com.better.cloud.common.annotation.enable;

import com.better.cloud.common.configure.BetterLettuceRedisConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lius
 * @description 开启指定的redisTemplate序列化方式
 * @date 2020/2/20
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BetterLettuceRedisConfigure.class)
public @interface EnableBetterLettuceRedis {
}
