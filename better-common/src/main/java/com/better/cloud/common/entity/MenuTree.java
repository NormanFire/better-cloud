package com.better.cloud.common.entity;

import com.better.cloud.common.entity.upms.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author MrBird
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuTree extends Tree<Menu>{

    private String path;
    private String component;
    private String perms;
    private String icon;
    private String type;
    private Integer orderNum;
}
