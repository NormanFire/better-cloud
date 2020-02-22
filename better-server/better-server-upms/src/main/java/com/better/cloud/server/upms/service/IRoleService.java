package com.better.cloud.server.upms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.upms.Role;

import java.util.List;

public interface IRoleService extends IService<Role> {

    IPage<Role> findRoles(Role role, QueryRequest request);

    List<Role> findUserRole(String userName);

    List<Role> findAllRoles();

    Role findByName(String roleName);

    void createRole(Role role);

    void deleteRoles(String[] roleIds);

    void updateRole(Role role);
}
