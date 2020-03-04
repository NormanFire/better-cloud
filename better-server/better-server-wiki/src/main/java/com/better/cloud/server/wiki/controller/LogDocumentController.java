package com.better.cloud.server.wiki.controller;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.wiki.LogDocument;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.server.wiki.service.ILogDocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static com.better.cloud.common.utils.BetterUtil.getDataTable;

/**
 * 文档日志表 Controller
 *
 * @author better
 * @date 2020-03-04 14:49:27
 */
@Slf4j
@Validated
@RestController
@RequestMapping("logDocument")
public class LogDocumentController  {

    @Autowired
    private ILogDocumentService logDocumentService;

    @GetMapping
//    @PreAuthorize("hasAuthority('logDocument:list')")
    public BetterResponse getAllLogDocuments(LogDocument logDocument) {
        return new BetterResponse().data(logDocumentService.findLogDocuments(logDocument));
    }

    @GetMapping("list")
//    @PreAuthorize("hasAuthority('logDocument:list')")
    public BetterResponse logDocumentList(QueryRequest request, LogDocument logDocument) {
        Map<String, Object> dataTable = getDataTable(this.logDocumentService.findLogDocuments(request, logDocument));
        return new BetterResponse().data(dataTable);
    }

    @PostMapping
//    @PreAuthorize("hasAuthority('logDocument:add')")
    public void addLogDocument(@Valid LogDocument logDocument) throws BetterException {
        try {
            this.logDocumentService.createLogDocument(logDocument);
        } catch (Exception e) {
            String message = "新增LogDocument失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping
//    @PreAuthorize("hasAuthority('logDocument:delete')")
    public void deleteLogDocument(LogDocument logDocument) throws BetterException {
        try {
            this.logDocumentService.deleteLogDocument(logDocument);
        } catch (Exception e) {
            String message = "删除LogDocument失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @PutMapping
//    @PreAuthorize("hasAuthority('logDocument:update')")
    public void updateLogDocument(LogDocument logDocument) throws BetterException {
        try {
            this.logDocumentService.updateLogDocument(logDocument);
        } catch (Exception e) {
            String message = "修改LogDocument失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
