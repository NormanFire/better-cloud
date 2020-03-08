package com.better.cloud.server.bill.service;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.SysBillCategory;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author better
 * @date 2020-03-08 09:58:46
 */
public interface ISysBillCategoryService extends IService<SysBillCategory> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param sysBillCategory sysBillCategory
     * @return IPage<SysBillCategory>
     */
    IPage<SysBillCategory> findSysBillCategorys(QueryRequest request, SysBillCategory sysBillCategory);

    /**
     * 查询（所有）
     *
     * @param sysBillCategory sysBillCategory
     * @return List<SysBillCategory>
     */
    List<SysBillCategory> findSysBillCategorys(SysBillCategory sysBillCategory);

    /**
     * 新增
     *
     * @param sysBillCategory sysBillCategory
     */
    void createSysBillCategory(SysBillCategory sysBillCategory);

    /**
     * 修改
     *
     * @param sysBillCategory sysBillCategory
     */
    void updateSysBillCategory(SysBillCategory sysBillCategory);

    /**
     * 删除
     *
     * @param sysBillCategory sysBillCategory
     */
    void deleteSysBillCategory(SysBillCategory sysBillCategory);
}
