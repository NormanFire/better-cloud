package com.better.cloud.server.bill.service;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.SysCategoryType;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author better
 * @date 2020-03-08 09:58:53
 */
public interface ISysCategoryTypeService extends IService<SysCategoryType> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param sysCategoryType sysCategoryType
     * @return IPage<SysCategoryType>
     */
    IPage<SysCategoryType> findSysCategoryTypes(QueryRequest request, SysCategoryType sysCategoryType);

    /**
     * 查询（所有）
     *
     * @param sysCategoryType sysCategoryType
     * @return List<SysCategoryType>
     */
    List<SysCategoryType> findSysCategoryTypes(SysCategoryType sysCategoryType);

    /**
     * 新增
     *
     * @param sysCategoryType sysCategoryType
     */
    void createSysCategoryType(SysCategoryType sysCategoryType);

    /**
     * 修改
     *
     * @param sysCategoryType sysCategoryType
     */
    void updateSysCategoryType(SysCategoryType sysCategoryType);

    /**
     * 删除
     *
     * @param sysCategoryType sysCategoryType
     */
    void deleteSysCategoryType(SysCategoryType sysCategoryType);
}
