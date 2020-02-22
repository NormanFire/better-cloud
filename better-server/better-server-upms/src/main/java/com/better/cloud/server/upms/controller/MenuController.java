package com.better.cloud.server.upms.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.better.cloud.common.annotation.ControllerEndpoint;
import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.router.VueRouter;
import com.better.cloud.common.entity.upms.Menu;
import com.better.cloud.server.upms.service.IMenuService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MrBird
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @GetMapping("/{username}")
    public BetterResponse getUserRouters(@NotBlank(message = "{required}") @PathVariable String username) {
        Map<String, Object> result = new HashMap<>();
        List<VueRouter<Menu>> userRouters = this.menuService.getUserRouters(username);
        String userPermissions = this.menuService.findUserPermissions(username);
        String[] permissionArray = new String[0];
        if (StringUtils.isNoneBlank(userPermissions)) {
            permissionArray = StringUtils.splitByWholeSeparatorPreserveAllTokens(userPermissions, ",");
        }
        result.put("routes", userRouters);
        result.put("permissions", permissionArray);
        return new BetterResponse().data(result);
    }

    @GetMapping
    public BetterResponse menuList(Menu menu) {
        Map<String, Object> menus = this.menuService.findMenus(menu);
        return new BetterResponse().data(menus);
    }

    @GetMapping("/permissions")
    public String findUserPermissions(String username) {
        return this.menuService.findUserPermissions(username);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('menu:add')")
    @ControllerEndpoint(operation = "新增菜单/按钮", exceptionMessage = "新增菜单/按钮失败")
    public void addMenu(@Valid Menu menu) {
        this.menuService.createMenu(menu);
    }

    @DeleteMapping("/{menuIds}")
    @PreAuthorize("hasAuthority('menu:delete')")
    @ControllerEndpoint(operation = "删除菜单/按钮", exceptionMessage = "删除菜单/按钮失败")
    public void deleteMenus(@NotBlank(message = "{required}") @PathVariable String menuIds) {
        String[] ids = menuIds.split(StringPool.COMMA);
        this.menuService.deleteMeuns(ids);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('menu:update')")
    @ControllerEndpoint(operation = "修改菜单/按钮", exceptionMessage = "修改菜单/按钮失败")
    public void updateMenu(@Valid Menu menu) {
        this.menuService.updateMenu(menu);
    }

    @PostMapping("excel")
    @PreAuthorize("hasAuthority('menu:export')")
    @ControllerEndpoint(operation = "导出菜单数据", exceptionMessage = "导出Excel失败")
    public void export(Menu menu, HttpServletResponse response) {
        List<Menu> menus = this.menuService.findMenuList(menu);
        ExcelKit.$Export(Menu.class, response).downXlsx(menus, false);
    }
}