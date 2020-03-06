package com.better.cloud.server.wiki.controller;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.wiki.Space;
import com.better.cloud.common.exception.BetterException;

import com.better.cloud.server.wiki.service.ISpaceService;
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
 * 空间表 Controller
 *
 * @author better
 * @date 2020-02-28 19:04:36
 */
@Slf4j
@Validated
@RestController
@RequestMapping("space")
public class SpaceController {

    @Autowired
    private ISpaceService spaceService;

    @GetMapping
//    @PreAuthorize("hasAuthority('space:list')")
    public BetterResponse getAllSpaces(Space space) {
        return new BetterResponse().data(spaceService.findSpaces(space));
    }

    @GetMapping("list")
//    @PreAuthorize("hasAuthority('space:list')")
    public BetterResponse spaceList(QueryRequest request, Space space) {
        Map<String, Object> dataTable = getDataTable(this.spaceService.findSpaces(request, space));
        return new BetterResponse().data(dataTable);
    }


    @PostMapping
//    @PreAuthorize("hasAuthority('space:add')")
    public void addSpace(@Valid Space space) throws BetterException {
        try {
            this.spaceService.createSpace(space);
        } catch (Exception e) {
            String message = "新增Space失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping
//    @PreAuthorize("hasAuthority('space:delete')")
    public void deleteSpace(Space space) throws BetterException {
        try {
            this.spaceService.deleteSpace(space);
        } catch (Exception e) {
            String message = "删除Space失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @PutMapping
//    @PreAuthorize("hasAuthority('space:update')")
    public void updateSpace(Space space) throws BetterException {
        try {
            this.spaceService.updateSpace(space);
        } catch (Exception e) {
            String message = "修改Space失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
