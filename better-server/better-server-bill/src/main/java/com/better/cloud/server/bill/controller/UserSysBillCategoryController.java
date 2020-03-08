package com.better.cloud.server.bill.controller;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.server.bill.entity.UserSysBillCategory;
import com.better.cloud.server.bill.service.IUserSysBillCategoryService;
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
 * @date 2020-03-08 09:58:48
 */
@Slf4j
@Validated
@RestController
@RequestMapping("userSysBillCategory")
public class UserSysBillCategoryController  {

    @Autowired
    private IUserSysBillCategoryService userSysBillCategoryService;

    @GetMapping
    @PreAuthorize("hasAuthority('userSysBillCategory:list')")
    public BetterResponse getAllUserSysBillCategorys(UserSysBillCategory userSysBillCategory) {
        return new BetterResponse().data(userSysBillCategoryService.findUserSysBillCategorys(userSysBillCategory));
    }

    @GetMapping("list")
    @PreAuthorize("hasAuthority('userSysBillCategory:list')")
    public BetterResponse userSysBillCategoryList(QueryRequest request, UserSysBillCategory userSysBillCategory) {
        Map<String, Object> dataTable = getDataTable(this.userSysBillCategoryService.findUserSysBillCategorys(request, userSysBillCategory));
        return new BetterResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('userSysBillCategory:add')")
    public void addUserSysBillCategory(@Valid UserSysBillCategory userSysBillCategory) throws BetterException {
        try {
            this.userSysBillCategoryService.createUserSysBillCategory(userSysBillCategory);
        } catch (Exception e) {
            String message = "新增UserSysBillCategory失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('userSysBillCategory:delete')")
    public void deleteUserSysBillCategory(UserSysBillCategory userSysBillCategory) throws BetterException {
        try {
            this.userSysBillCategoryService.deleteUserSysBillCategory(userSysBillCategory);
        } catch (Exception e) {
            String message = "删除UserSysBillCategory失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('userSysBillCategory:update')")
    public void updateUserSysBillCategory(UserSysBillCategory userSysBillCategory) throws BetterException {
        try {
            this.userSysBillCategoryService.updateUserSysBillCategory(userSysBillCategory);
        } catch (Exception e) {
            String message = "修改UserSysBillCategory失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
