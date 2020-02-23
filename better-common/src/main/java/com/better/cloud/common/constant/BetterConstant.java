package com.better.cloud.common.constant;

/**
 * @author lius
 * @description
 * @date 2020/2/20
 */
public class BetterConstant {

    /**
     * 注册用户角色ID
     */
    public static final Long REGISTER_ROLE_ID = 2L;

    /**
     * Java默认临时目录
     */
    public static final String JAVA_TEMP_DIR = "java.io.tmpdir";

    /**
     * 排序规则：降序
     */
    public static final String ORDER_DESC = "descending";
    /**
     * 排序规则：升序
     */
    public static final String ORDER_ASC = "ascending";

    /**
     * Zuul请求头TOKEN名称（不要有空格）
     */
    public static final String GATEWAY_TOKEN_HEADER = "GatewayToken";
    /**
     * Zuul请求头TOKEN值
     */
    public static final String GATEWAY_TOKEN_VALUE = "better:gateway:123456";

    /**
     * 异步线程池名称
     */
    public static final String ASYNC_POOL = "betterAsyncThreadPool";

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

    /**
     * utf-8
     */
    public static final String UTF8 = "utf-8";

    /**
     * 允许下载的文件类型，根据需求自己添加（小写）
     */
    public static final String[] VALID_FILE_TYPE = {"xlsx", "zip"};

}
