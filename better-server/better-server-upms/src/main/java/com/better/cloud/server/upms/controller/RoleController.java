package com.better.cloud.server.upms.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.better.cloud.common.annotation.ControllerEndpoint;
import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.QueryRequest;
import com.better.cloud.common.entity.upms.Role;
import com.better.cloud.common.utils.BetterUtil;
import com.better.cloud.server.upms.service.IRoleService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    private String message;

    @GetMapping
    public BetterResponse roleList(QueryRequest queryRequest, Role role) {
        Map<String, Object> dataTable = BetterUtil.getDataTable(roleService.findRoles(role, queryRequest));
        return new BetterResponse().data(dataTable);
    }

    @GetMapping("options")
    public BetterResponse roles() {
        List<Role> allRoles = roleService.findAllRoles();
        return new BetterResponse().data(allRoles);
    }

    @GetMapping("check/{roleName}")
    public boolean checkRoleName(@NotBlank(message = "{required}") @PathVariable String roleName) {
        Role result = this.roleService.findByName(roleName);
        return result == null;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('role:add')")
    @ControllerEndpoint(operation = "新增角色", exceptionMessage = "新增角色失败")
    public void addRole(@Valid Role role) {
        this.roleService.createRole(role);
    }

    @DeleteMapping("/{roleIds}")
    @PreAuthorize("hasAuthority('role:delete')")
    @ControllerEndpoint(operation = "删除角色", exceptionMessage = "删除角色失败")
    public void deleteRoles(@NotBlank(message = "{required}") @PathVariable String roleIds) {
        String[] ids = roleIds.split(StringPool.COMMA);
        this.roleService.deleteRoles(ids);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('role:update')")
    @ControllerEndpoint(operation = "修改角色", exceptionMessage = "修改角色失败")
    public void updateRole(@Valid Role role) {
        this.roleService.updateRole(role);
    }

    @PostMapping("excel")
    @PreAuthorize("hasAuthority('role:export')")
    @ControllerEndpoint(operation = "导出角色数据", exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, Role role, HttpServletResponse response) {
        List<Role> roles = this.roleService.findRoles(role, queryRequest).getRecords();
        ExcelKit.$Export(Role.class, response).downXlsx(roles, false);
    }
}
