package com.better.cloud.server.bill.entity;

import java.math.BigDecimal;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author better
 * @date 2020-03-08 09:58:45
 */
@Data
@TableName("user_assets")
public class UserAssets {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父id（所属类型）
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 账户名
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 资产类型（0：存款账户，1：负债账户）
     */
    @TableField("type")
    private Byte type;

    /**
     * 账户名称
     */
    @TableField("name")
    private String name;

    /**
     * 是否定级账户 （0：是，1：不是）
     */
    @TableField("is_top")
    private Byte isTop;

    /**
     * 账户金额
     */
    @TableField("amount")
    private BigDecimal amount;
    /**
     * 
     */
    @TableField("icon_url")
    private String iconUrl;

    /**
     * 删除标记（0：存在，1：删除）
     */
    @TableField("del_flag")
    private Byte delFlag;

}