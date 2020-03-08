package com.better.cloud.server.bill.service.impl;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.UserBudget;
import com.better.cloud.server.bill.mapper.UserBudgetMapper;
import com.better.cloud.server.bill.service.IUserBudgetService;
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
 * @date 2020-03-08 09:58:51
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserBudgetServiceImpl extends ServiceImpl<UserBudgetMapper, UserBudget> implements IUserBudgetService {

    @Autowired
    private UserBudgetMapper userBudgetMapper;

    @Override
    public IPage<UserBudget> findUserBudgets(QueryRequest request, UserBudget userBudget) {
        LambdaQueryWrapper<UserBudget> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<UserBudget> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<UserBudget> findUserBudgets(UserBudget userBudget) {
	    LambdaQueryWrapper<UserBudget> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createUserBudget(UserBudget userBudget) {
        this.save(userBudget);
    }

    @Override
    @Transactional
    public void updateUserBudget(UserBudget userBudget) {
        this.saveOrUpdate(userBudget);
    }

    @Override
    @Transactional
    public void deleteUserBudget(UserBudget userBudget) {
        LambdaQueryWrapper<UserBudget> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
