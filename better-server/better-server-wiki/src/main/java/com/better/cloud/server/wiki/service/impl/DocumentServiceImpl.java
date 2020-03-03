package com.better.cloud.server.wiki.service.impl;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.wiki.Document;
import com.better.cloud.server.wiki.mapper.DocumentMapper;
import com.better.cloud.server.wiki.service.IDocumentService;
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
 * 文档表 Service实现
 *
 * @author better
 * @date 2020-02-28 19:04:26
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DocumentServiceImpl extends ServiceImpl<DocumentMapper, Document> implements IDocumentService {

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public IPage<Document> findDocuments(QueryRequest request, Document document) {
        LambdaQueryWrapper<Document> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Document> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Document> findDocuments(Document document) {
	    LambdaQueryWrapper<Document> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createDocument(Document document) {
        this.save(document);
    }

    @Override
    @Transactional
    public void updateDocument(Document document) {
        this.saveOrUpdate(document);
    }

    @Override
    @Transactional
    public void deleteDocument(Document document) {
        LambdaQueryWrapper<Document> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
