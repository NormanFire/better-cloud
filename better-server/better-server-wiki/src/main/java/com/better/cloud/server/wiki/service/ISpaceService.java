package com.better.cloud.server.wiki.service;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.wiki.Space;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 空间表 Service接口
 *
 * @author better
 * @date 2020-02-28 19:04:36
 */
public interface ISpaceService extends IService<Space> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param space space
     * @return IPage<Space>
     */
    IPage<Space> findSpaces(QueryRequest request, Space space);

    /**
     * 查询（所有）
     *
     * @param space space
     * @return List<Space>
     */
    List<Space> findSpaces(Space space);

    /**
     * 新增
     *
     * @param space space
     */
    void createSpace(Space space);

    /**
     * 修改
     *
     * @param space space
     */
    void updateSpace(Space space);

    /**
     * 删除
     *
     * @param space space
     */
    void deleteSpace(Space space);
}
