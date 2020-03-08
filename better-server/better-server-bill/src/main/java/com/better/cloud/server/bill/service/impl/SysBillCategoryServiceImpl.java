package com.better.cloud.server.bill.service.impl;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.server.bill.entity.SysBillCategory;
import com.better.cloud.server.bill.mapper.SysBillCategoryMapper;
import com.better.cloud.server.bill.service.ISysBillCategoryService;
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
 * @date 2020-03-08 09:58:46
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysBillCategoryServiceImpl extends ServiceImpl<SysBillCategoryMapper, SysBillCategory> implements ISysBillCategoryService {

    @Autowired
    private SysBillCategoryMapper sysBillCategoryMapper;

    @Override
    public IPage<SysBillCategory> findSysBillCategorys(QueryRequest request, SysBillCategory sysBillCategory) {
        LambdaQueryWrapper<SysBillCategory> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<SysBillCategory> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<SysBillCategory> findSysBillCategorys(SysBillCategory sysBillCategory) {
	    LambdaQueryWrapper<SysBillCategory> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createSysBillCategory(SysBillCategory sysBillCategory) {
        this.save(sysBillCategory);
    }

    @Override
    @Transactional
    public void updateSysBillCategory(SysBillCategory sysBillCategory) {
        this.saveOrUpdate(sysBillCategory);
    }

    @Override
    @Transactional
    public void deleteSysBillCategory(SysBillCategory sysBillCategory) {
        LambdaQueryWrapper<SysBillCategory> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
