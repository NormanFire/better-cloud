package com.better.cloud.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.better.cloud.common.entity.upms.SystemUser;
import org.springframework.stereotype.Repository;

/**
 * @author lius
 * @description
 * @date 2020/2/20
 */
@Repository
public interface UserMapper extends BaseMapper<SystemUser> {
    SystemUser findByName(String username);
}

