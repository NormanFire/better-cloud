package com.better.cloud.server.wiki.controller;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.wiki.Log;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.server.wiki.service.ILogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.util.Map;

import static com.better.cloud.common.utils.BetterUtil.getDataTable;

/**
 * 系统操作日志表 Controller
 *
 * @author better
 * @date 2020-02-28 19:04:44
 */
@Slf4j
@Validated
@RestController
@RequestMapping("log")
public class LogController {

    @Autowired
    private ILogService logService;

    @GetMapping
//    @PreAuthorize("hasAuthority('log:list')")
    public BetterResponse getAllLogs(Log log) {
        return new BetterResponse().data(logService.findLogs(log));
    }

    @GetMapping("list")
//    @PreAuthorize("hasAuthority('log:list')")
    public BetterResponse logList(QueryRequest request, Log log) {
        return new BetterResponse().data(this.logService.findLogs(request, log));
    }


    @PostMapping
//    @PreAuthorize("hasAuthority('log:add')")
    public void addLog(@Valid Log log) throws BetterException {
        try {
            this.logService.createLog(log);
        } catch (Exception e) {
            String message = "新增Log失败";
            throw new BetterException(message);
        }
    }

    @DeleteMapping
//    @PreAuthorize("hasAuthority('log:delete')")
    public void deleteLog(Log log) throws BetterException {
        try {
            this.logService.deleteLog(log);
        } catch (Exception e) {
            String message = "删除Log失败";
            throw new BetterException(message);
        }
    }

    @PutMapping
//    @PreAuthorize("hasAuthority('log:update')")
    public void updateLog(Log log) throws BetterException {
        try {
            this.logService.updateLog(log);
        } catch (Exception e) {
            String message = "修改Log失败";
            throw new BetterException(message);
        }
    }
}
