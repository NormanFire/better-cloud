package com.better.cloud.server.bill.service.impl;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.SysCategoryType;
import com.better.cloud.server.bill.mapper.SysCategoryTypeMapper;
import com.better.cloud.server.bill.service.ISysCategoryTypeService;
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
 * @date 2020-03-08 09:58:53
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysCategoryTypeServiceImpl extends ServiceImpl<SysCategoryTypeMapper, SysCategoryType> implements ISysCategoryTypeService {

    @Autowired
    private SysCategoryTypeMapper sysCategoryTypeMapper;

    @Override
    public IPage<SysCategoryType> findSysCategoryTypes(QueryRequest request, SysCategoryType sysCategoryType) {
        LambdaQueryWrapper<SysCategoryType> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<SysCategoryType> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<SysCategoryType> findSysCategoryTypes(SysCategoryType sysCategoryType) {
	    LambdaQueryWrapper<SysCategoryType> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createSysCategoryType(SysCategoryType sysCategoryType) {
        this.save(sysCategoryType);
    }

    @Override
    @Transactional
    public void updateSysCategoryType(SysCategoryType sysCategoryType) {
        this.saveOrUpdate(sysCategoryType);
    }

    @Override
    @Transactional
    public void deleteSysCategoryType(SysCategoryType sysCategoryType) {
        LambdaQueryWrapper<SysCategoryType> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
