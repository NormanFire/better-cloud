package com.better.cloud.server.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.better.cloud.common.entity.upms.GeneratorConfig;

/**
 * @author MrBird
 */
public interface IGeneratorConfigService extends IService<GeneratorConfig> {

    /**
     * 查询
     *
     * @return GeneratorConfig
     */
    GeneratorConfig findGeneratorConfig();

    /**
     * 修改
     *
     * @param generatorConfig generatorConfig
     */
    void updateGeneratorConfig(GeneratorConfig generatorConfig);

}
