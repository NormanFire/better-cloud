package com.better.cloud.server.bill.service;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.UserAssets;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.better.cloud.server.bill.entity.UserAssetsStatisticsBO;

import java.util.List;
import java.util.Map;

/**
 *  Service接口
 *
 * @author better
 * @date 2020-03-08 09:58:45
 */
public interface IUserAssetsService extends IService<UserAssets> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param userAssets userAssets
     * @return IPage<UserAssets>
     */
    IPage<UserAssets> findUserAssetss(QueryRequest request, UserAssets userAssets);

    /**
     * 查询（所有）
     *
     * @param userAssets userAssets
     * @return List<UserAssets>
     */
    List<UserAssets> findUserAssetss(UserAssets userAssets);

    /**
     * 根据用户id查询用户资产统计详情
     * @return Map<String,Object>
     */
    UserAssetsStatisticsBO findUserAssetsStatisticsByUserId(Integer userId);


    /**
     * 新增
     *
     * @param userAssets userAssets
     */
    void createUserAssets(UserAssets userAssets);

    /**
     * 修改
     *
     * @param userAssets userAssets
     */
    void updateUserAssets(UserAssets userAssets);

    /**
     * 删除
     *
     * @param userAssets userAssets
     */
    void deleteUserAssets(UserAssets userAssets);

    /**
     * 根据id查询账单详情
     * @param assetsId
     * @param userId
     * @return UserAssets
     */
    UserAssets findUserAssetsDetailsById(String assetsId, int userId);
}
