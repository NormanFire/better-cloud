package com.better.cloud.server.upms.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.better.cloud.common.annotation.ControllerEndpoint;
import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.upms.LoginLog;
import com.better.cloud.common.utils.BetterUtil;
import com.better.cloud.server.upms.service.ILoginLogService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("loginLog")
public class LoginLogController {

    @Autowired
    private ILoginLogService loginLogService;

    @GetMapping
    public BetterResponse loginLogList(LoginLog loginLog, QueryRequest request) {
        Map<String, Object> dataTable = BetterUtil.getDataTable(this.loginLogService.findLoginLogs(loginLog, request));
        return new BetterResponse().data(dataTable);
    }

    @GetMapping("currentUser")
    public BetterResponse getUserLastSevenLoginLogs() {
//        String currentUsername = FebsUtil.getCurrentUsername();
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        List<LoginLog> userLastSevenLoginLogs = this.loginLogService.findUserLastSevenLoginLogs(currentUsername);
        return new BetterResponse().data(userLastSevenLoginLogs);
    }

    @DeleteMapping("{ids}")
    @PreAuthorize("hasAuthority('loginlog:delete')")
    @ControllerEndpoint(operation = "删除登录日志", exceptionMessage = "删除登录日志失败")
    public void deleteLogs(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] loginLogIds = ids.split(StringPool.COMMA);
        this.loginLogService.deleteLoginLogs(loginLogIds);
    }

    @PostMapping("excel")
    @PreAuthorize("hasAuthority('loginlog:export')")
    @ControllerEndpoint(operation = "导出登录日志数据", exceptionMessage = "导出Excel失败")
    public void export(QueryRequest request, LoginLog loginLog, HttpServletResponse response) {
        List<LoginLog> loginLogs = this.loginLogService.findLoginLogs(loginLog, request).getRecords();
        ExcelKit.$Export(LoginLog.class, response).downXlsx(loginLogs, false);
    }
}
