package com.better.cloud.server.mq.properties;

import lombok.Data;

/**
 * @author lius
 * @description
 * @date 2020/2/21
 */
@Data
public class SwaggerProperties {
    private String basePackage;
    private String title;
    private String description;
    private String version;
    private String author;
    private String url;
    private String email;
    private String license;
    private String licenseUrl;
    private String grantUrl;
    private String name;
    private String scope;
}
