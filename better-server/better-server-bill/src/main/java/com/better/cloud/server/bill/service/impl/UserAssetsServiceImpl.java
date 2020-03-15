package com.better.cloud.server.bill.service.impl;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.UserAssets;
import com.better.cloud.server.bill.entity.UserAssetsStatisticsBO;
import com.better.cloud.server.bill.enums.AssetsTypeEnum;
import com.better.cloud.server.bill.mapper.UserAssetsMapper;
import com.better.cloud.server.bill.service.IUserAssetsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 *  Service实现
 *
 * @author better
 * @date 2020-03-08 09:58:45
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserAssetsServiceImpl extends ServiceImpl<UserAssetsMapper, UserAssets> implements IUserAssetsService {

    @Autowired
    private UserAssetsMapper userAssetsMapper;

    @Override
    public IPage<UserAssets> findUserAssetss(QueryRequest request, UserAssets userAssets) {
        LambdaQueryWrapper<UserAssets> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<UserAssets> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<UserAssets> findUserAssetss(UserAssets userAssets) {
	    LambdaQueryWrapper<UserAssets> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public UserAssetsStatisticsBO findUserAssetsStatisticsByUserId(Integer userId) {
        UserAssetsStatisticsBO userAssetsStatisticsBO = new UserAssetsStatisticsBO();
        List<UserAssets> userAssetsList = userAssetsMapper.selectListByUserId(userId);
        if (userAssetsList != null){
            userAssetsList.forEach(userAssets -> {
                if (userAssets.getType() == AssetsTypeEnum.POSITIVE_ACCOUNT.getTypeCode()){
                    userAssetsStatisticsBO.addPositiveAssets(userAssets.getAmount());
                }else {
                    userAssetsStatisticsBO.addNegativeqAssets(userAssets.getAmount());
                }
            });
            userAssetsStatisticsBO.setUserAssetsList(userAssetsList);
            userAssetsStatisticsBO.calculateTotalAssets();
        }
        return userAssetsStatisticsBO;
    }

    @Override
    @Transactional
    public void createUserAssets(UserAssets userAssets) {
        this.save(userAssets);
    }

    @Override
    @Transactional
    public void updateUserAssets(UserAssets userAssets) {
        this.saveOrUpdate(userAssets);
    }

    @Override
    @Transactional
    public void deleteUserAssets(UserAssets userAssets) {
        LambdaQueryWrapper<UserAssets> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
