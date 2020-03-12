package com.better.cloud.server.bill.controller;

import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.common.utils.BetterUtil;
import com.better.cloud.server.bill.entity.UserFeedback;
import com.better.cloud.server.bill.service.IUserFeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
 * @date 2020-03-08 09:58:49
 */
@Slf4j
@Validated
@RestController
@RequestMapping("userFeedback")
public class UserFeedbackController{

    @Autowired
    private IUserFeedbackService userFeedbackService;

    @GetMapping
    @PreAuthorize("hasAuthority('userFeedback:list')")
    public BetterResponse getAllUserFeedbacks(UserFeedback userFeedback) {
        return new BetterResponse().data(userFeedbackService.findUserFeedbacks(userFeedback));
    }

    @GetMapping("list")
    @PreAuthorize("hasAuthority('userFeedback:list')")
    public BetterResponse userFeedbackList(QueryRequest request, UserFeedback userFeedback) {
        Map<String, Object> dataTable = getDataTable(this.userFeedbackService.findUserFeedbacks(request, userFeedback));
        return new BetterResponse().data(dataTable);
    }

    @PostMapping
//    @PreAuthorize("hasAuthority('userFeedback:add')")
    public void addUserFeedback(@Valid UserFeedback userFeedback) throws BetterException {
        try {
            userFeedback.setUserId(BetterUtil.getCurrentUser().getUserId().intValue());
            this.userFeedbackService.createUserFeedback(userFeedback);
        } catch (Exception e) {
            String message = "新增UserFeedback失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('userFeedback:delete')")
    public void deleteUserFeedback(UserFeedback userFeedback) throws BetterException {
        try {
            this.userFeedbackService.deleteUserFeedback(userFeedback);
        } catch (Exception e) {
            String message = "删除UserFeedback失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('userFeedback:update')")
    public void updateUserFeedback(UserFeedback userFeedback) throws BetterException {
        try {
            this.userFeedbackService.updateUserFeedback(userFeedback);
        } catch (Exception e) {
            String message = "修改UserFeedback失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
