package com.better.cloud.auth.manager;

import com.better.cloud.auth.mapper.MenuMapper;
import com.better.cloud.auth.mapper.UserMapper;
import com.better.cloud.auth.mapper.UserRoleMapper;
import com.better.cloud.common.constant.BetterConstant;
import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.upms.Menu;
import com.better.cloud.common.entity.upms.SystemUser;
import com.better.cloud.common.entity.upms.UserRole;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lius
 * @description
 * @date 2020/2/20
 */
@Service
public class UserManager {

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;

    public SystemUser findByName(String username) {
        return userMapper.findByName(username);
    }

    public String findUserPermissions(String username) {
        List<Menu> userPermissions = menuMapper.findUserPermissions(username);
        return userPermissions.stream().map(Menu::getPerms).collect(Collectors.joining(","));
    }

    /**
     * 注册用户
     *
     * @param username username
     * @param password password
     * @return SystemUser SystemUser
     */
    @Transactional
    public SystemUser registUser(String username,String password) {
        SystemUser systemUser = new SystemUser();
        systemUser.setUsername(username);
        systemUser.setPassword(password);
        systemUser.setCreateTime(new Date());
        systemUser.setStatus(SystemUser.STATUS_VALID);
        systemUser.setSex(SystemUser.SEX_UNKNOW);
        systemUser.setAvatar(SystemUser.DEFAULT_AVATAR);
        systemUser.setDescription("注册用户");
        this.userMapper.insert(systemUser);

        UserRole userRole = new UserRole();
        userRole.setUserId(systemUser.getUserId());
        userRole.setRoleId(BetterConstant.REGISTER_ROLE_ID); // 注册用户角色 ID
        this.userRoleMapper.insert(userRole);
        return systemUser;
    }
}

