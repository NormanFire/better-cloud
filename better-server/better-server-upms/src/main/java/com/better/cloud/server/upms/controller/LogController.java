package com.better.cloud.server.upms.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.better.cloud.common.annotation.ControllerEndpoint;
import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.upms.Log;
import com.better.cloud.common.utils.BetterUtil;
import com.better.cloud.server.upms.service.ILogService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * @author MrBird
 */
@Slf4j
@RestController
@RequestMapping("log")
public class LogController {

    @Autowired
    private ILogService logService;

    @GetMapping
    public BetterResponse logList(Log log, QueryRequest request) {
        Map<String, Object> dataTable = BetterUtil.getDataTable(this.logService.findLogs(log, request));
        return new BetterResponse().data(dataTable);
    }

    @DeleteMapping("{ids}")
    @PreAuthorize("hasAuthority('log:delete')")
    @ControllerEndpoint(exceptionMessage = "删除日志失败")
    public void deleteLogss(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] logIds = ids.split(StringPool.COMMA);
        this.logService.deleteLogs(logIds);
    }


    @PostMapping("excel")
    @PreAuthorize("hasAuthority('log:export')")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest request, Log lg, HttpServletResponse response) {
        List<Log> logs = this.logService.findLogs(lg, request).getRecords();
        ExcelKit.$Export(Log.class, response).downXlsx(logs, false);
    }
}
