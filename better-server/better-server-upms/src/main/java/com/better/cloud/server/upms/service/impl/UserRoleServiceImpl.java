package com.better.cloud.server.upms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.better.cloud.common.entity.upms.UserRole;
import com.better.cloud.server.upms.mapper.UserRoleMapper;
import com.better.cloud.server.upms.service.IUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * @author lius
 * @description
 * @date 2020/2/21
 */
@Service("userRoleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Override
    @Transactional
    public void deleteUserRolesByRoleId(String[] roleIds) {
        Arrays.stream(roleIds).forEach(id -> baseMapper.deleteByRoleId(Long.valueOf(id)));
    }

    @Override
    @Transactional
    public void deleteUserRolesByUserId(String[] userIds) {
        Arrays.stream(userIds).forEach(id -> baseMapper.deleteByUserId(Long.valueOf(id)));
    }
}
