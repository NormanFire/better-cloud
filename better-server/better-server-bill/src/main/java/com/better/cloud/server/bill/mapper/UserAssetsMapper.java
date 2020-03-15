package com.better.cloud.server.bill.mapper;

import com.better.cloud.server.bill.entity.UserAssets;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 *  Mapper
 *
 * @author better
 * @date 2020-03-08 09:58:45
 */
public interface UserAssetsMapper extends BaseMapper<UserAssets> {

    List<UserAssets> selectListByUserId(Integer userId);
}
