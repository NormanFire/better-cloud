package com.better.cloud.server.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.better.cloud.common.entity.upms.UserRole;

/**
 * @author lius
 * @description
 * @date 2020/2/21
 */
public interface IUserRoleService extends IService<UserRole> {

    void deleteUserRolesByRoleId(String[] roleIds);

    void deleteUserRolesByUserId(String[] userIds);
}

