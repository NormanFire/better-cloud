package com.better.cloud.server.gen.configure;

import com.better.cloud.common.constant.GeneratorConstant;
import com.better.cloud.server.gen.datasource.DynamicDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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


    @Bean(name = "masterDataSource")
    public DataSource masterDataSource(){
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
        log.info("获取配置的数据源 -> url: {}",url);
        return new HikariDataSource(config);
    }

    @Bean
    @Primary
    @Autowired
    public DynamicDataSource dataSource(@Qualifier("masterDataSource") DataSource masterDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(5);
        targetDataSources.put(GeneratorConstant.MASTER_DATASOURCE, masterDataSource);
        //默认generator datasource就是 master
        targetDataSources.put(GeneratorConstant.GEN_DATASOURCE, masterDataSource);
        return new DynamicDataSource(masterDataSource,targetDataSources);
    }
}
