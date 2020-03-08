package com.better.cloud.server.bill.service;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.UserBillCategory;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author better
 * @date 2020-03-08 09:58:41
 */
public interface IUserBillCategoryService extends IService<UserBillCategory> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param userBillCategory userBillCategory
     * @return IPage<UserBillCategory>
     */
    IPage<UserBillCategory> findUserBillCategorys(QueryRequest request, UserBillCategory userBillCategory);

    /**
     * 查询（所有）
     *
     * @param userBillCategory userBillCategory
     * @return List<UserBillCategory>
     */
    List<UserBillCategory> findUserBillCategorys(UserBillCategory userBillCategory);

    /**
     * 新增
     *
     * @param userBillCategory userBillCategory
     */
    void createUserBillCategory(UserBillCategory userBillCategory);

    /**
     * 修改
     *
     * @param userBillCategory userBillCategory
     */
    void updateUserBillCategory(UserBillCategory userBillCategory);

    /**
     * 删除
     *
     * @param userBillCategory userBillCategory
     */
    void deleteUserBillCategory(UserBillCategory userBillCategory);
}
