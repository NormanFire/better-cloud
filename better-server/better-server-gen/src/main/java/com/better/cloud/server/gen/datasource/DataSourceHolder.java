package com.better.cloud.server.gen.datasource;

/**
 * @author lius
 * @description
 * @date 2020/2/24
 */
public class DataSourceHolder {

    /**
     * 线程本地环境
     */
    private static final ThreadLocal<String> DATA_SOURCES = new ThreadLocal<String>();

    /**
     * 设置数据源
     * @param customerType
     */
    public static void setDataSource(String customerType) {
        DATA_SOURCES.set(customerType);
    }

    /**
     * 获取数据源
     * @return
     */
    public static String getDataSource() {
        return (String) DATA_SOURCES.get();
    }

    /**
     * 获取数据源
     */
    public static void clearDataSource() {
        DATA_SOURCES.remove();
    }
}
