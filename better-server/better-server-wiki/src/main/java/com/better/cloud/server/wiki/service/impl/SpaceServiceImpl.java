package com.better.cloud.server.wiki.service.impl;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.wiki.Space;
import com.better.cloud.server.wiki.mapper.SpaceMapper;
import com.better.cloud.server.wiki.service.ISpaceService;
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
 * 空间表 Service实现
 *
 * @author better
 * @date 2020-02-28 19:04:36
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SpaceServiceImpl extends ServiceImpl<SpaceMapper, Space> implements ISpaceService {

    @Autowired
    private SpaceMapper spaceMapper;

    @Override
    public IPage<Space> findSpaces(QueryRequest request, Space space) {
        LambdaQueryWrapper<Space> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Space> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Space> findSpaces(Space space) {
	    LambdaQueryWrapper<Space> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createSpace(Space space) {
        this.save(space);
    }

    @Override
    @Transactional
    public void updateSpace(Space space) {
        this.saveOrUpdate(space);
    }

    @Override
    @Transactional
    public void deleteSpace(Space space) {
        LambdaQueryWrapper<Space> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
