package com.better.cloud.server.wiki.service;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.wiki.LogDocument;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 文档日志表 Service接口
 *
 * @author better
 * @date 2020-03-04 14:49:27
 */
public interface ILogDocumentService extends IService<LogDocument> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param logDocument logDocument
     * @return IPage<LogDocument>
     */
    IPage<LogDocument> findLogDocuments(QueryRequest request, LogDocument logDocument);

    /**
     * 查询（所有）
     *
     * @param logDocument logDocument
     * @return List<LogDocument>
     */
    List<LogDocument> findLogDocuments(LogDocument logDocument);

    /**
     * 新增
     *
     * @param logDocument logDocument
     */
    void createLogDocument(LogDocument logDocument);

    /**
     * 修改
     *
     * @param logDocument logDocument
     */
    void updateLogDocument(LogDocument logDocument);

    /**
     * 删除
     *
     * @param logDocument logDocument
     */
    void deleteLogDocument(LogDocument logDocument);
}
