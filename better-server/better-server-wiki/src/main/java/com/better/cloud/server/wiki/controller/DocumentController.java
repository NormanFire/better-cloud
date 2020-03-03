package com.better.cloud.server.wiki.controller;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.wiki.Document;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.server.wiki.service.IDocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.util.Map;

import static com.better.cloud.common.utils.BetterUtil.getDataTable;

/**
 * 文档表 Controller
 *
 * @author better
 * @date 2020-02-28 19:04:26
 */
@Slf4j
@Validated
@RestController
@RequestMapping("document")
public class DocumentController {

    @Autowired
    private IDocumentService documentService;

    @GetMapping
    @PreAuthorize("hasAuthority('document:list')")
    public BetterResponse getAllDocuments(Document document) {
        return new BetterResponse().data(documentService.findDocuments(document));
    }

    @GetMapping("list")
    @PreAuthorize("hasAuthority('document:list')")
    public BetterResponse documentList(QueryRequest request, Document document) {
        Map<String, Object> dataTable = getDataTable(this.documentService.findDocuments(request, document));
        return new BetterResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('document:add')")
    public void addDocument(@Valid Document document) throws BetterException {
        try {
            this.documentService.createDocument(document);
        } catch (Exception e) {
            String message = "新增Document失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('document:delete')")
    public void deleteDocument(Document document) throws BetterException {
        try {
            this.documentService.deleteDocument(document);
        } catch (Exception e) {
            String message = "删除Document失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('document:update')")
    public void updateDocument(Document document) throws BetterException {
        try {
            this.documentService.updateDocument(document);
        } catch (Exception e) {
            String message = "修改Document失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
