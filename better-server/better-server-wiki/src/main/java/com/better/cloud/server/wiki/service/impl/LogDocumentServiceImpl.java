package com.better.cloud.server.wiki.service.impl;


import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.wiki.LogDocument;
import com.better.cloud.server.wiki.mapper.LogDocumentMapper;
import com.better.cloud.server.wiki.service.ILogDocumentService;
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
 * 文档日志表 Service实现
 *
 * @author better
 * @date 2020-03-04 14:49:27
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LogDocumentServiceImpl extends ServiceImpl<LogDocumentMapper, LogDocument> implements ILogDocumentService {

    @Autowired
    private LogDocumentMapper logDocumentMapper;

    @Override
    public IPage<LogDocument> findLogDocuments(QueryRequest request, LogDocument logDocument) {
        LambdaQueryWrapper<LogDocument> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<LogDocument> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<LogDocument> findLogDocuments(LogDocument logDocument) {
	    LambdaQueryWrapper<LogDocument> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createLogDocument(LogDocument logDocument) {
        this.save(logDocument);
    }

    @Override
    @Transactional
    public void updateLogDocument(LogDocument logDocument) {
        this.saveOrUpdate(logDocument);
    }

    @Override
    @Transactional
    public void deleteLogDocument(LogDocument logDocument) {
        LambdaQueryWrapper<LogDocument> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
