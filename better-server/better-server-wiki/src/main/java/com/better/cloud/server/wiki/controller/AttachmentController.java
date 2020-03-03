package com.better.cloud.server.wiki.controller;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.wiki.Attachment;
import com.better.cloud.common.exception.BetterException;

import com.better.cloud.server.wiki.service.IAttachmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.util.Map;

import static com.better.cloud.common.utils.BetterUtil.getDataTable;

/**
 * 附件信息表 Controller
 *
 * @author better
 * @date 2020-02-28 19:05:04
 */
@Slf4j
@Validated
@RestController
@RequestMapping("attachment")
public class AttachmentController {

    @Autowired
    private IAttachmentService attachmentService;

    @GetMapping
    @PreAuthorize("hasAuthority('attachment:list')")
    public BetterResponse getAllAttachments(Attachment attachment) {
        return new BetterResponse().data(attachmentService.findAttachments(attachment));
    }

    @GetMapping("list")
    @PreAuthorize("hasAuthority('attachment:list')")
    public BetterResponse attachmentList(QueryRequest request, Attachment attachment) {
        Map<String, Object> dataTable = getDataTable(this.attachmentService.findAttachments(request, attachment));
        return new BetterResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('attachment:add')")
    public void addAttachment(@Valid Attachment attachment) throws BetterException {
        try {
            this.attachmentService.createAttachment(attachment);
        } catch (Exception e) {
            String message = "新增Attachment失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('attachment:delete')")
    public void deleteAttachment(Attachment attachment) throws BetterException {
        try {
            this.attachmentService.deleteAttachment(attachment);
        } catch (Exception e) {
            String message = "删除Attachment失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('attachment:update')")
    public void updateAttachment(Attachment attachment) throws BetterException {
        try {
            this.attachmentService.updateAttachment(attachment);
        } catch (Exception e) {
            String message = "修改Attachment失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
