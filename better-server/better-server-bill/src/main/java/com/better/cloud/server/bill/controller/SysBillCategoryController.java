package com.better.cloud.server.bill.controller;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.common.utils.BetterUtil;
import com.better.cloud.server.bill.entity.SysBillCategory;
import com.better.cloud.server.bill.service.ISysBillCategoryService;
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
 * @date 2020-03-08 09:58:46
 */
@Slf4j
@Validated
@RestController
@RequestMapping("sysBillCategory")
public class SysBillCategoryController {

    @Autowired
    private ISysBillCategoryService sysBillCategoryService;

    @GetMapping
    @PreAuthorize("hasAuthority('sysBillCategory:list')")
    public BetterResponse getAllSysBillCategorys(SysBillCategory sysBillCategory) {
        return new BetterResponse().data(sysBillCategoryService.findSysBillCategorys(sysBillCategory));
    }

    @GetMapping("list")
    @PreAuthorize("hasAuthority('sysBillCategory:list')")
    public BetterResponse sysBillCategoryList(QueryRequest request, SysBillCategory sysBillCategory) {
        Map<String, Object> dataTable = getDataTable(this.sysBillCategoryService.findSysBillCategorys(request, sysBillCategory));
        return new BetterResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('sysBillCategory:add')")
    public void addSysBillCategory(@Valid SysBillCategory sysBillCategory) throws BetterException {
        try {
            this.sysBillCategoryService.createSysBillCategory(sysBillCategory);
        } catch (Exception e) {
            String message = "新增SysBillCategory失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('sysBillCategory:delete')")
    public void deleteSysBillCategory(SysBillCategory sysBillCategory) throws BetterException {
        try {
            this.sysBillCategoryService.deleteSysBillCategory(sysBillCategory);
        } catch (Exception e) {
            String message = "删除SysBillCategory失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('sysBillCategory:update')")
    public void updateSysBillCategory(SysBillCategory sysBillCategory) throws BetterException {
        try {
            this.sysBillCategoryService.updateSysBillCategory(sysBillCategory);
        } catch (Exception e) {
            String message = "修改SysBillCategory失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
