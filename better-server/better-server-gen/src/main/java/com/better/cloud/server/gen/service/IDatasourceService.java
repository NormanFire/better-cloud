package com.better.cloud.server.gen.service;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.gen.Datasource;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author better
 * @date 2020-02-23 21:39:53
 */
public interface IDatasourceService extends IService<Datasource> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param datasource datasource
     * @return IPage<Datasource>
     */
    IPage<Datasource> findDatasources(QueryRequest request, Datasource datasource);

    /**
     * 查询（所有）
     *
     * @param datasource datasource
     * @return List<Datasource>
     */
    List<Datasource> findDatasources(Datasource datasource);

    /**
     * 新增
     *
     * @param datasource datasource
     */
    void createDatasource(Datasource datasource);

    /**
     * 修改
     *
     * @param datasource datasource
     */
    void updateDatasource(Datasource datasource);

    /**
     * 删除
     *
     * @param datasource datasource
     */
    void deleteDatasource(Datasource datasource);

    /**
     * 删除
     */
    void deleteDatasources(String[] ids);
}
