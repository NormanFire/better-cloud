package com.better.cloud.server.bill.service.impl;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.UserBill;
import com.better.cloud.server.bill.mapper.UserBillMapper;
import com.better.cloud.server.bill.service.IUserBillService;
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
 * @date 2020-03-08 09:58:43
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserBillServiceImpl extends ServiceImpl<UserBillMapper, UserBill> implements IUserBillService {

    @Autowired
    private UserBillMapper userBillMapper;

    @Override
    public IPage<UserBill> findUserBills(QueryRequest request, UserBill userBill) {
        LambdaQueryWrapper<UserBill> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<UserBill> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<UserBill> findUserBills(UserBill userBill) {
	    LambdaQueryWrapper<UserBill> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createUserBill(UserBill userBill) {
        this.save(userBill);
    }

    @Override
    @Transactional
    public void updateUserBill(UserBill userBill) {
        this.saveOrUpdate(userBill);
    }

    @Override
    @Transactional
    public void deleteUserBill(UserBill userBill) {
        LambdaQueryWrapper<UserBill> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
