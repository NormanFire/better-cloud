package com.better.cloud.server.upms.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.upms.Eximport;
import com.better.cloud.server.upms.mapper.EximportMapper;
import com.better.cloud.server.upms.properties.BetterServerUPMSProperties;
import com.better.cloud.server.upms.service.IEximportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MrBird
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class EximportServiceImpl extends ServiceImpl<EximportMapper, Eximport> implements IEximportService {

    @Autowired
    private BetterServerUPMSProperties properties;

    @Override
    public IPage<Eximport> findEximports(QueryRequest request, Eximport eximport) {
        Page<Eximport> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, null);
    }

    @Override
    @Transactional
    public void batchInsert(List<Eximport> list) {
        this.saveBatch(list, properties.getBatchInsertMaxNum());
    }

}
