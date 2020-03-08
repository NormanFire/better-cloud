package com.better.cloud.server.bill.service;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.UserBudget;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author better
 * @date 2020-03-08 09:58:51
 */
public interface IUserBudgetService extends IService<UserBudget> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param userBudget userBudget
     * @return IPage<UserBudget>
     */
    IPage<UserBudget> findUserBudgets(QueryRequest request, UserBudget userBudget);

    /**
     * 查询（所有）
     *
     * @param userBudget userBudget
     * @return List<UserBudget>
     */
    List<UserBudget> findUserBudgets(UserBudget userBudget);

    /**
     * 新增
     *
     * @param userBudget userBudget
     */
    void createUserBudget(UserBudget userBudget);

    /**
     * 修改
     *
     * @param userBudget userBudget
     */
    void updateUserBudget(UserBudget userBudget);

    /**
     * 删除
     *
     * @param userBudget userBudget
     */
    void deleteUserBudget(UserBudget userBudget);
}
