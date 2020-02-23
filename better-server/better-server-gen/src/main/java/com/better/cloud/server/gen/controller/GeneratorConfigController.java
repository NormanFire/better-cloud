package com.better.cloud.server.gen.controller;

import com.better.cloud.common.annotation.ControllerEndpoint;
import com.better.cloud.common.entity.BetterResponse;
import com.better.cloud.common.entity.upms.GeneratorConfig;
import com.better.cloud.common.exception.BetterException;
import com.better.cloud.server.gen.service.IGeneratorConfigService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author MrBird
 */
@Slf4j
@RestController
@RequestMapping("genConfig")
public class GeneratorConfigController {

    @Autowired
    private IGeneratorConfigService generatorConfigService;

    @GetMapping
    @PreAuthorize("hasAuthority('gen:config')")
    public BetterResponse getGeneratorConfig() {
        return new BetterResponse().data(generatorConfigService.findGeneratorConfig());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('gen:config:update')")
    @ControllerEndpoint(operation = "修改生成代码配置", exceptionMessage = "修改GeneratorConfig失败")
    public void updateGeneratorConfig(@Valid GeneratorConfig generatorConfig) throws BetterException {
        if (StringUtils.isBlank(generatorConfig.getId())) {
            throw new BetterException("配置id不能为空");
        }
        this.generatorConfigService.updateGeneratorConfig(generatorConfig);
    }
}
