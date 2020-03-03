package com.better.cloud.server.wiki.service;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.wiki.Attachment;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 附件信息表 Service接口
 *
 * @author better
 * @date 2020-02-28 19:05:04
 */
public interface IAttachmentService extends IService<Attachment> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param attachment attachment
     * @return IPage<Attachment>
     */
    IPage<Attachment> findAttachments(QueryRequest request, Attachment attachment);

    /**
     * 查询（所有）
     *
     * @param attachment attachment
     * @return List<Attachment>
     */
    List<Attachment> findAttachments(Attachment attachment);

    /**
     * 新增
     *
     * @param attachment attachment
     */
    void createAttachment(Attachment attachment);

    /**
     * 修改
     *
     * @param attachment attachment
     */
    void updateAttachment(Attachment attachment);

    /**
     * 删除
     *
     * @param attachment attachment
     */
    void deleteAttachment(Attachment attachment);
}
