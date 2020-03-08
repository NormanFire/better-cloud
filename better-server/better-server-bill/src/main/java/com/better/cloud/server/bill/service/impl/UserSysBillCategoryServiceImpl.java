package com.better.cloud.server.bill.service.impl;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.UserSysBillCategory;
import com.better.cloud.server.bill.mapper.UserSysBillCategoryMapper;
import com.better.cloud.server.bill.service.IUserSysBillCategoryService;
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
 * @date 2020-03-08 09:58:48
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserSysBillCategoryServiceImpl extends ServiceImpl<UserSysBillCategoryMapper, UserSysBillCategory> implements IUserSysBillCategoryService {

    @Autowired
    private UserSysBillCategoryMapper userSysBillCategoryMapper;

    @Override
    public IPage<UserSysBillCategory> findUserSysBillCategorys(QueryRequest request, UserSysBillCategory userSysBillCategory) {
        LambdaQueryWrapper<UserSysBillCategory> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<UserSysBillCategory> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<UserSysBillCategory> findUserSysBillCategorys(UserSysBillCategory userSysBillCategory) {
	    LambdaQueryWrapper<UserSysBillCategory> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createUserSysBillCategory(UserSysBillCategory userSysBillCategory) {
        this.save(userSysBillCategory);
    }

    @Override
    @Transactional
    public void updateUserSysBillCategory(UserSysBillCategory userSysBillCategory) {
        this.saveOrUpdate(userSysBillCategory);
    }

    @Override
    @Transactional
    public void deleteUserSysBillCategory(UserSysBillCategory userSysBillCategory) {
        LambdaQueryWrapper<UserSysBillCategory> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
