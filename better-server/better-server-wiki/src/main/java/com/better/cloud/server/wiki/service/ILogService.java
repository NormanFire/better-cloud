package com.better.cloud.server.wiki.service;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.wiki.Log;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 系统操作日志表 Service接口
 *
 * @author better
 * @date 2020-02-28 19:04:44
 */
public interface ILogService extends IService<Log> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param log log
     * @return IPage<Log>
     */
    IPage<Log> findLogs(QueryRequest request, Log log);

    /**
     * 查询（所有）
     *
     * @param log log
     * @return List<Log>
     */
    List<Log> findLogs(Log log);

    /**
     * 新增
     *
     * @param log log
     */
    void createLog(Log log);

    /**
     * 修改
     *
     * @param log log
     */
    void updateLog(Log log);

    /**
     * 删除
     *
     * @param log log
     */
    void deleteLog(Log log);
}
