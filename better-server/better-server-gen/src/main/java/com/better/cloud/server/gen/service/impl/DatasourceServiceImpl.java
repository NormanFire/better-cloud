package com.better.cloud.server.gen.service.impl;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.gen.Datasource;
import com.better.cloud.server.gen.mapper.DatasourceMapper;
import com.better.cloud.server.gen.service.IDatasourceService;
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
 * @date 2020-02-23 21:39:53
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DatasourceServiceImpl extends ServiceImpl<DatasourceMapper, Datasource> implements IDatasourceService {

    @Autowired
    private DatasourceMapper datasourceMapper;

    @Override
    public IPage<Datasource> findDatasources(QueryRequest request, Datasource datasource) {
        LambdaQueryWrapper<Datasource> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Datasource> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Datasource> findDatasources(Datasource datasource) {
	    LambdaQueryWrapper<Datasource> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createDatasource(Datasource datasource) {
        this.save(datasource);
    }

    @Override
    @Transactional
    public void updateDatasource(Datasource datasource) {
        this.saveOrUpdate(datasource);
    }

    @Override
    @Transactional
    public void deleteDatasource(Datasource datasource) {
        LambdaQueryWrapper<Datasource> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
