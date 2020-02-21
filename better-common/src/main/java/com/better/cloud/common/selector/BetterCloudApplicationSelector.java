package com.better.cloud.common.selector;

import com.better.cloud.common.configure.BetterAuthExceptionConfigure;
import com.better.cloud.common.configure.BetterOAuth2FeignConfigure;
import com.better.cloud.common.configure.BetterServerProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lius
 * @description 使用selector注册多个configure类
 * @date 2020/2/21
 */
public class BetterCloudApplicationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                BetterAuthExceptionConfigure.class.getName(),
                BetterOAuth2FeignConfigure.class.getName(),
                BetterServerProtectConfigure.class.getName()
        };
    }
}

