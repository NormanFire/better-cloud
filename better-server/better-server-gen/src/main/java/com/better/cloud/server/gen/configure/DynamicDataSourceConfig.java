package com.better.cloud.server.gen.configure;

import com.better.cloud.common.constant.GeneratorConstant;
import com.better.cloud.server.gen.datasource.DynamicDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lius
 * @description
 * @date 2020/2/24
 */
@Slf4j
@Configuration
public class DynamicDataSourceConfig {

    @Value("${spring.datasource.dynamic.datasource.base.username}")
    private String username;
    @Value("${spring.datasource.dynamic.datasource.base.password}")
    private String password;
    @Value("${spring.datasource.dynamic.datasource.base.url}")
    private String url;


    @Bean
    public DataSource baseDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl( url );
        config.setUsername( username);
        config.setPassword( password );
        config.addDataSourceProperty( "connectionTimeout" , "30000" );
        config.addDataSourceProperty( "maxLifetime" , "1800000" );
        config.addDataSourceProperty( "maxPoolSize" , "15" );
        config.addDataSourceProperty( "minIdle" , "2048" );
        config.addDataSourceProperty( "connectionTestQuery" , "2048" );
        config.addDataSourceProperty( "poolName" , "BetterHikariCP" );
        log.info("获取base数据源 -> url: {}",url);
        return new HikariDataSource(config);
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource baseDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(5);
        targetDataSources.put(GeneratorConstant.BASE_DATASOURCE, baseDataSource);
        return new DynamicDataSource(baseDataSource,targetDataSources);
    }
}
