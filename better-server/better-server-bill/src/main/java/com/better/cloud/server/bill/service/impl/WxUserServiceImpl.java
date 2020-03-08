package com.better.cloud.server.bill.service.impl;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.WxUser;
import com.better.cloud.server.bill.mapper.WxUserMapper;
import com.better.cloud.server.bill.service.IWxUserService;
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
 * @date 2020-03-08 09:58:03
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class WxUserServiceImpl extends ServiceImpl<WxUserMapper, WxUser> implements IWxUserService {

    @Autowired
    private WxUserMapper wxUserMapper;

    @Override
    public IPage<WxUser> findWxUsers(QueryRequest request, WxUser wxUser) {
        LambdaQueryWrapper<WxUser> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<WxUser> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<WxUser> findWxUsers(WxUser wxUser) {
	    LambdaQueryWrapper<WxUser> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createWxUser(WxUser wxUser) {
        this.save(wxUser);
    }

    @Override
    @Transactional
    public void updateWxUser(WxUser wxUser) {
        this.saveOrUpdate(wxUser);
    }

    @Override
    @Transactional
    public void deleteWxUser(WxUser wxUser) {
        LambdaQueryWrapper<WxUser> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
