package com.better.cloud.server.bill.service.impl;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.UserFeedback;
import com.better.cloud.server.bill.mapper.UserFeedbackMapper;
import com.better.cloud.server.bill.service.IUserFeedbackService;
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
 * @date 2020-03-08 09:58:49
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserFeedbackServiceImpl extends ServiceImpl<UserFeedbackMapper, UserFeedback> implements IUserFeedbackService {

    @Autowired
    private UserFeedbackMapper userFeedbackMapper;

    @Override
    public IPage<UserFeedback> findUserFeedbacks(QueryRequest request, UserFeedback userFeedback) {
        LambdaQueryWrapper<UserFeedback> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<UserFeedback> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<UserFeedback> findUserFeedbacks(UserFeedback userFeedback) {
	    LambdaQueryWrapper<UserFeedback> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createUserFeedback(UserFeedback userFeedback) {
        this.save(userFeedback);
    }

    @Override
    @Transactional
    public void updateUserFeedback(UserFeedback userFeedback) {
        this.saveOrUpdate(userFeedback);
    }

    @Override
    @Transactional
    public void deleteUserFeedback(UserFeedback userFeedback) {
        LambdaQueryWrapper<UserFeedback> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
