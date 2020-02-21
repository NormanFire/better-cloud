package com.better.cloud.common.constant;

/**
 * @author lius
 * @description
 * @date 2020/2/20
 */
public class BetterConstant {

    /**
     * Zuul请求头TOKEN名称（不要有空格）
     */
    public static final String GATEWAY_TOKEN_HEADER = "GatewayToken";
    /**
     * Zuul请求头TOKEN值
     */
    public static final String GATEWAY_TOKEN_VALUE = "better:gateway:123456";

    /**
     * gif类型
     */
    public static final String GIF = "gif";
    /**
     * png类型
     */
    public static final String PNG = "png";

    /**
     * 验证码 key前缀
     */
    public static final String CODE_PREFIX = "better.captcha.";

}
