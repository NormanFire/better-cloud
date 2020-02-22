package com.better.cloud.server.upms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.upms.Column;
import com.better.cloud.common.entity.upms.Table;

import java.util.List;

/**
 * @author MrBird
 */
public interface IGeneratorService {

    List<String> getDatabases(String databaseType);

    IPage<Table> getTables(String tableName, QueryRequest request, String databaseType, String schemaName);

    List<Column> getColumns(String databaseType, String schemaName, String tableName);
}
