package com.better.cloud.server.bill.service.impl;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.UserBillCategory;
import com.better.cloud.server.bill.mapper.UserBillCategoryMapper;
import com.better.cloud.server.bill.service.IUserBillCategoryService;
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
 * @date 2020-03-08 09:58:41
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserBillCategoryServiceImpl extends ServiceImpl<UserBillCategoryMapper, UserBillCategory> implements IUserBillCategoryService {

    @Autowired
    private UserBillCategoryMapper userBillCategoryMapper;

    @Override
    public IPage<UserBillCategory> findUserBillCategorys(QueryRequest request, UserBillCategory userBillCategory) {
        LambdaQueryWrapper<UserBillCategory> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<UserBillCategory> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<UserBillCategory> findUserBillCategorys(UserBillCategory userBillCategory) {
	    LambdaQueryWrapper<UserBillCategory> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createUserBillCategory(UserBillCategory userBillCategory) {
        this.save(userBillCategory);
    }

    @Override
    @Transactional
    public void updateUserBillCategory(UserBillCategory userBillCategory) {
        this.saveOrUpdate(userBillCategory);
    }

    @Override
    @Transactional
    public void deleteUserBillCategory(UserBillCategory userBillCategory) {
        LambdaQueryWrapper<UserBillCategory> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
