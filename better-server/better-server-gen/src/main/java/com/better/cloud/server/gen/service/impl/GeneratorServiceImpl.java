package com.better.cloud.server.gen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.better.cloud.common.constant.BetterConstant;
import com.better.cloud.common.constant.GeneratorConstant;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.gen.Column;
import com.better.cloud.common.entity.gen.Datasource;
import com.better.cloud.common.entity.gen.Table;
import com.better.cloud.common.utils.SortUtil;
import com.better.cloud.server.gen.datasource.DataSource;
import com.better.cloud.server.gen.datasource.DynamicDataSource;
import com.better.cloud.server.gen.mapper.DatasourceMapper;
import com.better.cloud.server.gen.mapper.GeneratorMapper;
import com.better.cloud.server.gen.service.IGeneratorService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MrBird
 */
@Service
@Slf4j
@DataSource(name = GeneratorConstant.GEN_DATASOURCE)
public class GeneratorServiceImpl implements IGeneratorService {
    @Autowired
    private GeneratorMapper generatorMapper;

    @Autowired
    private DatasourceMapper datasourceMapper;

    @Autowired
    private DynamicDataSource dynamicDataSource;

    @Autowired
    @Qualifier("masterDataSource")
    private javax.sql.DataSource masterDataSource;

    @Override
    public List<String> getDatabases(String databaseType) {
        return generatorMapper.getDatabases(databaseType);
    }

    @Override
    public IPage<Table> getTables(String tableName, QueryRequest request, String databaseType, String datasourceName) {
        Page<Table> page = new Page<>(request.getPageNum(), request.getPageSize());
        QueryWrapper<Datasource> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DATASOURCE_NAME",datasourceName);
        Datasource datasource = datasourceMapper.selectOne(queryWrapper);
        this.setGeneratorDataSource(datasource);
        SortUtil.handlePageSort(request, page, "createTime", BetterConstant.ORDER_ASC, false);
        return generatorMapper.getTables(page, tableName, databaseType, datasource.getSchemaName());
    }

    @Override
    public List<Column> getColumns(String databaseType, String schemaName, String tableName) {
        return generatorMapper.getColumns(databaseType, schemaName, tableName);
    }

    private void setGeneratorDataSource(Datasource datasource){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl( datasource.getJdbcUrl() );
        config.setUsername( datasource.getUsername());
        config.setPassword( datasource.getPassword() );
        config.addDataSourceProperty( "connectionTimeout" , "30000" );
        config.addDataSourceProperty( "maxLifetime" , "1800000" );
        config.addDataSourceProperty( "maxPoolSize" , "15" );
        config.addDataSourceProperty( "minIdle" , "2048" );
        config.addDataSourceProperty( "connectionTestQuery" , "2048" );
        config.addDataSourceProperty( "poolName" , "BetterHikariCP" );
        log.info("获取配置的数据源 -> url: {}",datasource.getJdbcUrl());
        HikariDataSource generatorSource = new HikariDataSource(config);
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(GeneratorConstant.MASTER_DATASOURCE,masterDataSource);
        targetDataSources.put(GeneratorConstant.GEN_DATASOURCE,generatorSource);
        dynamicDataSource.setTargetDataSources(targetDataSources);
    }
}
