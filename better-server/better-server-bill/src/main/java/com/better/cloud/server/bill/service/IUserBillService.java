package com.better.cloud.server.bill.service;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.UserBill;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author better
 * @date 2020-03-08 09:58:43
 */
public interface IUserBillService extends IService<UserBill> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param userBill userBill
     * @return IPage<UserBill>
     */
    IPage<UserBill> findUserBills(QueryRequest request, UserBill userBill);

    /**
     * 查询（所有）
     *
     * @param userBill userBill
     * @return List<UserBill>
     */
    List<UserBill> findUserBills(UserBill userBill);

    /**
     * 新增
     *
     * @param userBill userBill
     */
    void createUserBill(UserBill userBill);

    /**
     * 修改
     *
     * @param userBill userBill
     */
    void updateUserBill(UserBill userBill);

    /**
     * 删除
     *
     * @param userBill userBill
     */
    void deleteUserBill(UserBill userBill);
}
