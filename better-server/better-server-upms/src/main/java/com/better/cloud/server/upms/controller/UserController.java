package com.better.cloud.server.upms.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.better.cloud.common.annotation.ControllerEndpoint;
import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.upms.LoginLog;
import com.better.cloud.common.entity.upms.SystemUser;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.common.utils.BetterUtil;
import com.better.cloud.server.upms.service.ILoginLogService;
import com.better.cloud.server.upms.service.IUserService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MrBird
 */
@Slf4j
@Validated
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private ILoginLogService loginLogService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("success")
    public void loginSuccess(HttpServletRequest request) {
//        String currentUsername = FebsUtil.getCurrentUsername();
        // update last login time
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        this.userService.updateLoginTime(currentUsername);
        // save login log
        LoginLog loginLog = new LoginLog();
        loginLog.setUsername(currentUsername);
        loginLog.setSystemBrowserInfo(request.getHeader("user-agent"));
        this.loginLogService.saveLoginLog(loginLog);
    }

    @GetMapping("index")
    public BetterResponse index() {
        Map<String, Object> data = new HashMap<>();
        // 获取系统访问记录
        Long totalVisitCount = loginLogService.findTotalVisitCount();
        data.put("totalVisitCount", totalVisitCount);
        Long todayVisitCount = loginLogService.findTodayVisitCount();
        data.put("todayVisitCount", todayVisitCount);
        Long todayIp = loginLogService.findTodayIp();
        data.put("todayIp", todayIp);
        // 获取近期系统访问记录
        List<Map<String, Object>> lastTenVisitCount = loginLogService.findLastTenDaysVisitCount(null);
        data.put("lastTenVisitCount", lastTenVisitCount);
        SystemUser param = new SystemUser();
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
//        param.setUsername(FebsUtil.getCurrentUsername());
        param.setUsername(currentUsername);
        List<Map<String, Object>> lastTenUserVisitCount = loginLogService.findLastTenDaysVisitCount(param);
        data.put("lastTenUserVisitCount", lastTenUserVisitCount);
        return new BetterResponse().data(data);
    }


    @GetMapping
    @PreAuthorize("hasAuthority('user:view')")
    public BetterResponse userList(QueryRequest queryRequest, SystemUser user) {
        Map<String, Object> dataTable = BetterUtil.getDataTable(userService.findUserDetailList(user, queryRequest));
        return new BetterResponse().data(dataTable);
    }

    @GetMapping("check/{username}")
    public boolean checkUserName(@NotBlank(message = "{required}") @PathVariable String username) {
        return this.userService.findByName(username) == null;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:add')")
    @ControllerEndpoint(operation = "新增用户", exceptionMessage = "新增用户失败")
    public void addUser(@Valid SystemUser user) {
        this.userService.createUser(user);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('user:update')")
    @ControllerEndpoint(operation = "修改用户", exceptionMessage = "修改用户失败")
    public void updateUser(@Valid SystemUser user) {
        this.userService.updateUser(user);
    }

    @DeleteMapping("/{userIds}")
    @PreAuthorize("hasAuthority('user:delete')")
    @ControllerEndpoint(operation = "删除用户", exceptionMessage = "删除用户失败")
    public void deleteUsers(@NotBlank(message = "{required}") @PathVariable String userIds) {
        String[] ids = userIds.split(StringPool.COMMA);
        this.userService.deleteUsers(ids);
    }

    @PutMapping("profile")
    @ControllerEndpoint(exceptionMessage = "修改个人信息失败")
    public void updateProfile(@Valid SystemUser user) throws BetterException {
        this.userService.updateProfile(user);
    }

    @PutMapping("avatar")
    @ControllerEndpoint(exceptionMessage = "修改头像失败")
    public void updateAvatar(@NotBlank(message = "{required}") String avatar) {
        this.userService.updateAvatar(avatar);
    }

    @GetMapping("password/check")
    public boolean checkPassword(@NotBlank(message = "{required}") String password) {
//        String currentUsername = FebsUtil.getCurrentUsername();
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        SystemUser user = userService.findByName(currentUsername);
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }

    @PutMapping("password")
    @ControllerEndpoint(exceptionMessage = "修改密码失败")
    public void updatePassword(@NotBlank(message = "{required}") String password) {
        userService.updatePassword(password);
    }

    @PutMapping("password/reset")
    @PreAuthorize("hasAuthority('user:reset')")
    @ControllerEndpoint(exceptionMessage = "重置用户密码失败")
    public void resetPassword(@NotBlank(message = "{required}") String usernames) {
        String[] usernameArr = usernames.split(StringPool.COMMA);
        this.userService.resetPassword(usernameArr);
    }

    @PostMapping("excel")
    @PreAuthorize("hasAuthority('user:export')")
    @ControllerEndpoint(operation = "导出用户数据", exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, SystemUser user, HttpServletResponse response) {
        List<SystemUser> users = this.userService.findUserDetailList(user, queryRequest).getRecords();
        ExcelKit.$Export(SystemUser.class, response).downXlsx(users, false);
    }
}
