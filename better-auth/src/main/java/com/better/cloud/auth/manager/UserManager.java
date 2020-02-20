package com.better.cloud.auth.manager;

import com.better.cloud.auth.mapper.MenuMapper;
import com.better.cloud.auth.mapper.UserMapper;
import com.better.cloud.common.entity.upms.Menu;
import com.better.cloud.common.entity.upms.SystemUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}

