package com.better.cloud.common.entity;

import com.better.cloud.common.entity.upms.Dept;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author MrBird
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptTree extends Tree<Dept>{

    private Integer orderNum;
}
