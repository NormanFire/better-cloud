package com.better.cloud.server.upms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.better.cloud.common.entity.upms.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> findUserPermissions(String userName);

    List<Menu> findUserMenus(String userName);
}