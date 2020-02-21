package com.better.cloud.common.annotation;

import com.better.cloud.common.selector.BetterCloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lius
 * @description
 * @date 2020/2/21
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BetterCloudApplicationSelector.class)
public @interface BetterCloudApplication {

}
