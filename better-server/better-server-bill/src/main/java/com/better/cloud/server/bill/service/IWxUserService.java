package com.better.cloud.server.bill.service;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.WxUser;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author better
 * @date 2020-03-08 09:58:03
 */
public interface IWxUserService extends IService<WxUser> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param wxUser wxUser
     * @return IPage<WxUser>
     */
    IPage<WxUser> findWxUsers(QueryRequest request, WxUser wxUser);

    /**
     * 查询（所有）
     *
     * @param wxUser wxUser
     * @return List<WxUser>
     */
    List<WxUser> findWxUsers(WxUser wxUser);

    /**
     * 新增
     *
     * @param wxUser wxUser
     */
    void createWxUser(WxUser wxUser);

    /**
     * 修改
     *
     * @param wxUser wxUser
     */
    void updateWxUser(WxUser wxUser);

    /**
     * 删除
     *
     * @param wxUser wxUser
     */
    void deleteWxUser(WxUser wxUser);
}
