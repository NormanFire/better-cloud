package com.better.cloud.server.bill.controller;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.common.utils.BetterUtil;
import com.better.cloud.server.bill.entity.UserAssets;
import com.better.cloud.server.bill.service.IUserAssetsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
 * @date 2020-03-08 09:58:45
 */
@Slf4j
@Validated
@RestController
@RequestMapping("userAssets")
public class UserAssetsController {

    @Autowired
    private IUserAssetsService userAssetsService;

    @GetMapping
    @PreAuthorize("hasAuthority('userAssets:list')")
    public BetterResponse getAllUserAssetss(UserAssets userAssets) {
        return new BetterResponse().data(userAssetsService.findUserAssetss(userAssets));
    }

    @GetMapping("list")
    @PreAuthorize("hasAuthority('userAssets:list')")
    public BetterResponse userAssetsList(QueryRequest request, UserAssets userAssets) {
        Map<String, Object> dataTable = getDataTable(this.userAssetsService.findUserAssetss(request, userAssets));
        return new BetterResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('userAssets:add')")
    public void addUserAssets(@Valid UserAssets userAssets) throws BetterException {
        try {
            userAssets.setUserId(BetterUtil.getCurrentUser().getUserId().intValue());
            this.userAssetsService.createUserAssets(userAssets);
        } catch (Exception e) {
            String message = "新增UserAssets失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('userAssets:delete')")
    public void deleteUserAssets(UserAssets userAssets) throws BetterException {
        try {
            this.userAssetsService.deleteUserAssets(userAssets);
        } catch (Exception e) {
            String message = "删除UserAssets失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('userAssets:update')")
    public void updateUserAssets(UserAssets userAssets) throws BetterException {
        try {
            this.userAssetsService.updateUserAssets(userAssets);
        } catch (Exception e) {
            String message = "修改UserAssets失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
