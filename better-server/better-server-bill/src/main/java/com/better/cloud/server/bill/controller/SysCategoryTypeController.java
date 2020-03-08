package com.better.cloud.server.bill.controller;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.server.bill.entity.SysCategoryType;
import com.better.cloud.server.bill.service.ISysCategoryTypeService;
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
 * @date 2020-03-08 09:58:53
 */
@Slf4j
@Validated
@RestController
@RequestMapping("sysCategoryType")
public class SysCategoryTypeController {

    @Autowired
    private ISysCategoryTypeService sysCategoryTypeService;

    @GetMapping
    @PreAuthorize("hasAuthority('sysCategoryType:list')")
    public BetterResponse getAllSysCategoryTypes(SysCategoryType sysCategoryType) {
        return new BetterResponse().data(sysCategoryTypeService.findSysCategoryTypes(sysCategoryType));
    }

    @GetMapping("list")
    @PreAuthorize("hasAuthority('sysCategoryType:list')")
    public BetterResponse sysCategoryTypeList(QueryRequest request, SysCategoryType sysCategoryType) {
        Map<String, Object> dataTable = getDataTable(this.sysCategoryTypeService.findSysCategoryTypes(request, sysCategoryType));
        return new BetterResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('sysCategoryType:add')")
    public void addSysCategoryType(@Valid SysCategoryType sysCategoryType) throws BetterException {
        try {
            this.sysCategoryTypeService.createSysCategoryType(sysCategoryType);
        } catch (Exception e) {
            String message = "新增SysCategoryType失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('sysCategoryType:delete')")
    public void deleteSysCategoryType(SysCategoryType sysCategoryType) throws BetterException {
        try {
            this.sysCategoryTypeService.deleteSysCategoryType(sysCategoryType);
        } catch (Exception e) {
            String message = "删除SysCategoryType失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('sysCategoryType:update')")
    public void updateSysCategoryType(SysCategoryType sysCategoryType) throws BetterException {
        try {
            this.sysCategoryTypeService.updateSysCategoryType(sysCategoryType);
        } catch (Exception e) {
            String message = "修改SysCategoryType失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
