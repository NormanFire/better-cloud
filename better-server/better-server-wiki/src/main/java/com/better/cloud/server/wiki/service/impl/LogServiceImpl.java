package com.better.cloud.server.wiki.service.impl;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.wiki.Log;

import com.better.cloud.server.wiki.mapper.LogMapper;
import com.better.cloud.server.wiki.service.ILogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;

/**
 * 系统操作日志表 Service实现
 *
 * @author better
 * @date 2020-02-28 19:04:44
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public IPage<Log> findLogs(QueryRequest request, Log log) {
        LambdaQueryWrapper<Log> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Log::getIp,"");
        Page<Log> logPage = new Page<>();
        logPage.setCurrent(request.getPageNum()-1).setSize(request.getPageSize());
        return this.page(logPage);
    }



    @Override
    public List<Log> findLogs(Log log) {
	    LambdaQueryWrapper<Log> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createLog(Log log) {
        this.save(log);
    }

    @Override
    @Transactional
    public void updateLog(Log log) {
        this.saveOrUpdate(log);
    }

    @Override
    @Transactional
    public void deleteLog(Log log) {
        LambdaQueryWrapper<Log> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
