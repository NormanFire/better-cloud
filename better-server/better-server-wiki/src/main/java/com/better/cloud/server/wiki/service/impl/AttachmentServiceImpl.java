package com.better.cloud.server.wiki.service.impl;

import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.wiki.Attachment;
import com.better.cloud.server.wiki.mapper.AttachmentMapper;
import com.better.cloud.server.wiki.service.IAttachmentService;
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
 * 附件信息表 Service实现
 *
 * @author better
 * @date 2020-02-28 19:05:04
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment> implements IAttachmentService {

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    public IPage<Attachment> findAttachments(QueryRequest request, Attachment attachment) {
        LambdaQueryWrapper<Attachment> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Attachment> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Attachment> findAttachments(Attachment attachment) {
	    LambdaQueryWrapper<Attachment> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createAttachment(Attachment attachment) {
        this.save(attachment);
    }

    @Override
    @Transactional
    public void updateAttachment(Attachment attachment) {
        this.saveOrUpdate(attachment);
    }

    @Override
    @Transactional
    public void deleteAttachment(Attachment attachment) {
        LambdaQueryWrapper<Attachment> wapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wapper);
	}
}
