package com.better.cloud.server.upms.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.upms.SystemUser;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.common.utils.BetterUtil;
import com.better.cloud.server.upms.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * @author lius
 * @description
 * @date 2020/2/21
 */
@Slf4j
@Validated
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('user:view')")
    public BetterResponse userList(QueryRequest queryRequest, SystemUser user) {
        Map<String, Object> dataTable = BetterUtil.getDataTable(userService.findUserDetail(user, queryRequest));
        return new BetterResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('user:add')")
    public void addUser(@Valid SystemUser user) throws BetterException {
        try {
            this.userService.createUser(user);
        } catch (Exception e) {
            String message = "新增用户失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('user:update')")
    public void updateUser(@Valid SystemUser user) throws BetterException {
        try {
            this.userService.updateUser(user);
        } catch (Exception e) {
            String message = "修改用户失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping("/{userIds}")
    @PreAuthorize("hasAnyAuthority('user:delete')")
    public void deleteUsers(@NotBlank(message = "{required}") @PathVariable String userIds) throws BetterException {
        try {
            String[] ids = userIds.split(StringPool.COMMA);
            this.userService.deleteUsers(ids);
        } catch (Exception e) {
            String message = "删除用户失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
