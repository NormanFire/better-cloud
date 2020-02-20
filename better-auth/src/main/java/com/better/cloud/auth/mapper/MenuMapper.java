package com.better.cloud.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.better.cloud.common.entity.upms.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lius
 * @description
 * @date 2020/2/20
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> findUserPermissions(String username);
}