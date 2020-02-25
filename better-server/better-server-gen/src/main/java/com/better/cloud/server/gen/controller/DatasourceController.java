package com.better.cloud.server.gen.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.better.cloud.common.annotation.ControllerEndpoint;
import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.common.entity.gen.Datasource;
import com.better.cloud.server.gen.service.IDatasourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.Map;

import static com.better.cloud.common.utils.BetterUtil.getDataTable;

/**
 *  Controller
 *
 * @author better
 * @date 2020-02-23 21:39:53
 */
@Slf4j
@Validated
@RestController
@RequestMapping("datasource")
public class DatasourceController {

    @Autowired
    private IDatasourceService datasourceService;

    @GetMapping
    @PreAuthorize("hasAuthority('datasource:list')")
    public BetterResponse getAllDatasources(Datasource datasource) {
        return new BetterResponse().data(datasourceService.findDatasources(datasource));
    }

    @GetMapping("list")
    @PreAuthorize("hasAuthority('datasource:list')")
    public BetterResponse datasourceList(QueryRequest request, Datasource datasource) {
        Map<String, Object> dataTable = getDataTable(this.datasourceService.findDatasources(request, datasource));
        return new BetterResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('datasource:add')")
    public void addDatasource(@Valid Datasource datasource) throws BetterException {
        try {
            this.datasourceService.createDatasource(datasource);
        } catch (Exception e) {
            String message = "新增Datasource失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('datasource:delete')")
    public void deleteDatasource(Datasource datasource) throws BetterException {
        try {
            this.datasourceService.deleteDatasource(datasource);
        } catch (Exception e) {
            String message = "删除Datasource失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping("/{ids}")
    @PreAuthorize("hasAuthority('datasource:delete')")
    @ControllerEndpoint(operation = "删除数据源", exceptionMessage = "删除数据源失败")
    public void deleteDatasources(@NotBlank(message = "{required}") @PathVariable String ids) throws BetterException {
        String[] split = ids.split(StringPool.COMMA);
        datasourceService.deleteDatasources(split);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('datasource:update')")
    public void updateDatasource(Datasource datasource) throws BetterException {
        try {
            this.datasourceService.updateDatasource(datasource);
        } catch (Exception e) {
            String message = "修改Datasource失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
