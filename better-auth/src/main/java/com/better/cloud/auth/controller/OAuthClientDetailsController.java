package com.better.cloud.auth.controller;

import com.better.cloud.auth.entity.OAuthClientDetails;
import com.better.cloud.auth.service.OAuthClientDetailsService;
import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.common.utils.BetterUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * @author Yuuki
 */
@Slf4j
@Validated
@RestController
@RequestMapping("client")
public class OAuthClientDetailsController {

    @Autowired
    private OAuthClientDetailsService oAuthClientDetailsService;

    @GetMapping("check/{clientId}")
    public boolean checkUserName(@NotBlank(message = "{required}") @PathVariable String clientId) {
        OAuthClientDetails client = this.oAuthClientDetailsService.findById(clientId);
        return client == null;
    }

    @GetMapping("secret/{clientId}")
    @PreAuthorize("hasAuthority('client:decrypt')")
    public BetterResponse getOriginClientSecret(@NotBlank(message = "{required}") @PathVariable String clientId) {
        OAuthClientDetails client = this.oAuthClientDetailsService.findById(clientId);
        String origin = client != null ? client.getOriginSecret() : StringUtils.EMPTY;
        return new BetterResponse().data(origin);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('client:view')")
    public BetterResponse oauthCliendetailsList(QueryRequest request, OAuthClientDetails oAuthClientDetails) {
        Map<String, Object> dataTable = BetterUtil.getDataTable(this.oAuthClientDetailsService.findOAuthClientDetails(request, oAuthClientDetails));
        return new BetterResponse().data(dataTable);
    }


    @PostMapping
    @PreAuthorize("hasAuthority('client:add')")
    public void addOauthCliendetails(@Valid OAuthClientDetails oAuthClientDetails) throws BetterException {
        try {
            this.oAuthClientDetailsService.createOAuthClientDetails(oAuthClientDetails);
        } catch (Exception e) {
            String message = "新增客户端失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('client:delete')")
    public void deleteOauthCliendetails(@NotBlank(message = "{required}") String clientIds) throws BetterException {
        try {
            this.oAuthClientDetailsService.deleteOAuthClientDetails(clientIds);
        } catch (Exception e) {
            String message = "删除客户端失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('client:update')")
    public void updateOauthCliendetails(@Valid OAuthClientDetails oAuthClientDetails) throws BetterException {
        try {
            this.oAuthClientDetailsService.updateOAuthClientDetails(oAuthClientDetails);
        } catch (Exception e) {
            String message = "修改客户端失败";
            log.error(message, e);
            throw new BetterException(message);
        }
    }
}
