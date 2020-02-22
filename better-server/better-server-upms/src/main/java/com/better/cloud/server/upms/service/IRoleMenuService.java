package com.better.cloud.server.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.better.cloud.common.entity.upms.RoleMenu;

import java.util.List;

public interface IRoleMenuService extends IService<RoleMenu> {

    void deleteRoleMenusByRoleId(String[] roleIds);

    void deleteRoleMenusByMenuId(String[] menuIds);

    List<RoleMenu> getRoleMenusByRoleId(String roleId);
}
