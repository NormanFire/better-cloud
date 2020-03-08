package com.better.cloud.server.bill.service;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.UserSysBillCategory;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author better
 * @date 2020-03-08 09:58:48
 */
public interface IUserSysBillCategoryService extends IService<UserSysBillCategory> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param userSysBillCategory userSysBillCategory
     * @return IPage<UserSysBillCategory>
     */
    IPage<UserSysBillCategory> findUserSysBillCategorys(QueryRequest request, UserSysBillCategory userSysBillCategory);

    /**
     * 查询（所有）
     *
     * @param userSysBillCategory userSysBillCategory
     * @return List<UserSysBillCategory>
     */
    List<UserSysBillCategory> findUserSysBillCategorys(UserSysBillCategory userSysBillCategory);

    /**
     * 新增
     *
     * @param userSysBillCategory userSysBillCategory
     */
    void createUserSysBillCategory(UserSysBillCategory userSysBillCategory);

    /**
     * 修改
     *
     * @param userSysBillCategory userSysBillCategory
     */
    void updateUserSysBillCategory(UserSysBillCategory userSysBillCategory);

    /**
     * 删除
     *
     * @param userSysBillCategory userSysBillCategory
     */
    void deleteUserSysBillCategory(UserSysBillCategory userSysBillCategory);
}
