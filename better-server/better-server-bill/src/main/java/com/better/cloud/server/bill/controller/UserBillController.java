package com.better.cloud.server.bill.controller;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.common.utils.BetterUtil;
import com.better.cloud.server.bill.entity.UserBill;
import com.better.cloud.server.bill.service.IUserBillService;
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
 * @date 2020-03-08 09:58:43
 */
@Slf4j
@Validated
@RestController
@RequestMapping("userBill")
public class UserBillController {

    @Autowired
    private IUserBillService userBillService;

    @GetMapping
    @PreAuthorize("hasAuthority('userBill:list')")
    public BetterResponse getAllUserBills(UserBill userBill) {
        return new BetterResponse().data(userBillService.findUserBills(userBill));
    }

    @GetMapping("list")
    @PreAuthorize("hasAuthority('userBill:list')")
    public BetterResponse userBillList(QueryRequest request, UserBill userBill) {
        Map<String, Object> dataTable = getDataTable(this.userBillService.findUserBills(request, userBill));
        return new BetterResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('userBill:add')")
    public void addUserBill(@Valid UserBill userBill) throws BetterException {
        try {
            userBill.setUserId(BetterUtil.getCurrentUser().getUserId().intValue());
            this.userBillService.createUserBill(userBill);
        } catch (Exception e) {
            String message = "新增UserBill失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('userBill:delete')")
    public void deleteUserBill(UserBill userBill) throws BetterException {
        try {
            this.userBillService.deleteUserBill(userBill);
        } catch (Exception e) {
            String message = "删除UserBill失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('userBill:update')")
    public void updateUserBill(UserBill userBill) throws BetterException {
        try {
            this.userBillService.updateUserBill(userBill);
        } catch (Exception e) {
            String message = "修改UserBill失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
