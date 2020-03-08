package com.better.cloud.server.bill.service;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.UserFeedback;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author better
 * @date 2020-03-08 09:58:49
 */
public interface IUserFeedbackService extends IService<UserFeedback> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param userFeedback userFeedback
     * @return IPage<UserFeedback>
     */
    IPage<UserFeedback> findUserFeedbacks(QueryRequest request, UserFeedback userFeedback);

    /**
     * 查询（所有）
     *
     * @param userFeedback userFeedback
     * @return List<UserFeedback>
     */
    List<UserFeedback> findUserFeedbacks(UserFeedback userFeedback);

    /**
     * 新增
     *
     * @param userFeedback userFeedback
     */
    void createUserFeedback(UserFeedback userFeedback);

    /**
     * 修改
     *
     * @param userFeedback userFeedback
     */
    void updateUserFeedback(UserFeedback userFeedback);

    /**
     * 删除
     *
     * @param userFeedback userFeedback
     */
    void deleteUserFeedback(UserFeedback userFeedback);
}
