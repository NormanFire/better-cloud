package com.better.cloud.server.bill.controller;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.server.bill.entity.UserBillCategory;
import com.better.cloud.server.bill.service.IUserBillCategoryService;
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
 * @date 2020-03-08 09:58:41
 */
@Slf4j
@Validated
@RestController
@RequestMapping("userBillCategory")
public class UserBillCategoryController {

    @Autowired
    private IUserBillCategoryService userBillCategoryService;

    @GetMapping
    @PreAuthorize("hasAuthority('userBillCategory:list')")
    public BetterResponse getAllUserBillCategorys(UserBillCategory userBillCategory) {
        return new BetterResponse().data(userBillCategoryService.findUserBillCategorys(userBillCategory));
    }

    @GetMapping("list")
    @PreAuthorize("hasAuthority('userBillCategory:list')")
    public BetterResponse userBillCategoryList(QueryRequest request, UserBillCategory userBillCategory) {
        Map<String, Object> dataTable = getDataTable(this.userBillCategoryService.findUserBillCategorys(request, userBillCategory));
        return new BetterResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('userBillCategory:add')")
    public void addUserBillCategory(@Valid UserBillCategory userBillCategory) throws BetterException {
        try {
            this.userBillCategoryService.createUserBillCategory(userBillCategory);
        } catch (Exception e) {
            String message = "新增UserBillCategory失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('userBillCategory:delete')")
    public void deleteUserBillCategory(UserBillCategory userBillCategory) throws BetterException {
        try {
            this.userBillCategoryService.deleteUserBillCategory(userBillCategory);
        } catch (Exception e) {
            String message = "删除UserBillCategory失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('userBillCategory:update')")
    public void updateUserBillCategory(UserBillCategory userBillCategory) throws BetterException {
        try {
            this.userBillCategoryService.updateUserBillCategory(userBillCategory);
        } catch (Exception e) {
            String message = "修改UserBillCategory失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
