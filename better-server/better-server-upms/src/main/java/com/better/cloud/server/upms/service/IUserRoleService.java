package com.better.cloud.server.upms.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.better.cloud.common.entity.upms.UserRole;

import java.util.List;

public interface IUserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(String[] roleIds);

	void deleteUserRolesByUserId(String[] userIds);

	List<String> findUserIdsByRoleId(String[] roleIds);
}
