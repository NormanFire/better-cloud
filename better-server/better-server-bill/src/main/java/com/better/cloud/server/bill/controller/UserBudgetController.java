package com.better.cloud.server.bill.controller;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.common.utils.BetterUtil;
import com.better.cloud.server.bill.entity.UserBudget;
import com.better.cloud.server.bill.service.IUserBudgetService;
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
 *  Controller
 *
 * @author better
 * @date 2020-03-08 09:58:51
 */
@Slf4j
@Validated
@RestController
@RequestMapping("userBudget")
public class UserBudgetController {

    @Autowired
    private IUserBudgetService userBudgetService;

    @GetMapping
    @PreAuthorize("hasAuthority('userBudget:list')")
    public BetterResponse getAllUserBudgets(UserBudget userBudget) {
        return new BetterResponse().data(userBudgetService.findUserBudgets(userBudget));
    }

    @GetMapping("list")
    @PreAuthorize("hasAuthority('userBudget:list')")
    public BetterResponse userBudgetList(QueryRequest request, UserBudget userBudget) {
        Map<String, Object> dataTable = getDataTable(this.userBudgetService.findUserBudgets(request, userBudget));
        return new BetterResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('userBudget:add')")
    public void addUserBudget(@Valid UserBudget userBudget) throws BetterException {
        try {
            userBudget.setUserId(BetterUtil.getCurrentUser().getUserId().intValue());
            this.userBudgetService.createUserBudget(userBudget);
        } catch (Exception e) {
            String message = "新增UserBudget失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('userBudget:delete')")
    public void deleteUserBudget(UserBudget userBudget) throws BetterException {
        try {
            this.userBudgetService.deleteUserBudget(userBudget);
        } catch (Exception e) {
            String message = "删除UserBudget失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('userBudget:update')")
    public void updateUserBudget(UserBudget userBudget) throws BetterException {
        try {
            this.userBudgetService.updateUserBudget(userBudget);
        } catch (Exception e) {
            String message = "修改UserBudget失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
