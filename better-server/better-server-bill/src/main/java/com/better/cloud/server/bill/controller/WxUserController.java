package com.better.cloud.server.bill.controller;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.server.bill.entity.WxUser;
import com.better.cloud.server.bill.service.IWxUserService;
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
 * @date 2020-03-08 09:58:03
 */
@Slf4j
@Validated
@RestController
@RequestMapping("wxUser")
public class WxUserController {

    @Autowired
    private IWxUserService wxUserService;

    @GetMapping
    @PreAuthorize("hasAuthority('wxUser:list')")
    public BetterResponse getAllWxUsers(WxUser wxUser) {
        return new BetterResponse().data(wxUserService.findWxUsers(wxUser));
    }

    @GetMapping("list")
    @PreAuthorize("hasAuthority('wxUser:list')")
    public BetterResponse wxUserList(QueryRequest request, WxUser wxUser) {
        Map<String, Object> dataTable = getDataTable(this.wxUserService.findWxUsers(request, wxUser));
        return new BetterResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('wxUser:add')")
    public void addWxUser(@Valid WxUser wxUser) throws BetterException {
        try {
            this.wxUserService.createWxUser(wxUser);
        } catch (Exception e) {
            String message = "新增WxUser失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('wxUser:delete')")
    public void deleteWxUser(WxUser wxUser) throws BetterException {
        try {
            this.wxUserService.deleteWxUser(wxUser);
        } catch (Exception e) {
            String message = "删除WxUser失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('wxUser:update')")
    public void updateWxUser(WxUser wxUser) throws BetterException {
        try {
            this.wxUserService.updateWxUser(wxUser);
        } catch (Exception e) {
            String message = "修改WxUser失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
