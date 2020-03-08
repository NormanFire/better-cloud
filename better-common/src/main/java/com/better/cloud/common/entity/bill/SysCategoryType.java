package com.better.cloud.common.entity.bill;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *  Entity
 *
 * @author better
 * @date 2020-03-08 09:58:53
 */
@Data
@TableName("sys_category_type")
public class SysCategoryType {

    /**
     * 分类类型（0：其它；1：支出；2：收入）
     */
    @TableId(value = "type_id", type = IdType.AUTO)
    private Byte typeId;

    /**
     * 
     */
    @TableField("type_name")
    private String typeName;

}