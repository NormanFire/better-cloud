package com.better.cloud.server.wiki.service;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.wiki.Document;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 文档表 Service接口
 *
 * @author better
 * @date 2020-02-28 19:04:26
 */
public interface IDocumentService extends IService<Document> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param document document
     * @return IPage<Document>
     */
    IPage<Document> findDocuments(QueryRequest request, Document document);

    /**
     * 查询（所有）
     *
     * @param document document
     * @return List<Document>
     */
    List<Document> findDocuments(Document document);

    /**
     * 新增
     *
     * @param document document
     */
    void createDocument(Document document);

    /**
     * 修改
     *
     * @param document document
     */
    void updateDocument(Document document);

    /**
     * 删除
     *
     * @param document document
     */
    void deleteDocument(Document document);
}
