package com.better.cloud.server.wiki.service.impl;

import com.better.cloud.common.entity.DocumentTree;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.Tree;
import com.better.cloud.common.entity.wiki.Document;
import com.better.cloud.common.utils.TreeUtil;
import com.better.cloud.server.wiki.mapper.DocumentMapper;
import com.better.cloud.server.wiki.service.IDocumentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文档表 Service实现
 *
 * @author better
 * @date 2020-02-28 19:04:26
 */
@Slf4j
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

    @Override
    public  List<? extends Tree<?>> getDocumentsBySpaceId(Integer spaceId) {
        Map<String ,Object> columnMap = new HashMap<>(1);
        columnMap.put("space_id",spaceId);
        List<Document> documents = documentMapper.selectByMap(columnMap);
        log.info("count: {}",documents.size());
        List<DocumentTree> documentTrees = new ArrayList<>();
        documents.forEach((document)->{
            DocumentTree documentTree = new DocumentTree();
            documentTree.setId(document.getDocumentId().toString());
            documentTree.setParentId(document.getParentId().toString());
            documentTree.setCreateUserId(document.getCreateUserId());
            documentTree.setDocumentId(document.getDocumentId());
            documentTree.setEditUserId(document.getEditUserId());
            documentTree.setName(document.getName());
            documentTree.setPath(document.getPath());
            documentTree.setSequence(document.getSequence());
            documentTree.setType(document.getType());
            documentTree.setLabel(document.getName());
            documentTrees.add(documentTree);
        });
        return TreeUtil.recursionBuild(documentTrees);
    }

    @Override
    public String getBreadcrumbByPath(String path) {
        String[] ids = StringUtils.splitByWholeSeparatorPreserveAllTokens(path, ",");
        for (String id : ids) {
            int intId = Integer.parseInt(id);
            if (intId != 0){
                Document document = documentMapper.selectById(intId);

            }
        }
        return null;
    }
}
