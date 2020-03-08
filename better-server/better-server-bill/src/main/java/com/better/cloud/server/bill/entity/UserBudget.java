package com.better.cloud.server.bill.entity;

import java.util.Date;
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
 * @date 2020-03-08 09:58:51
 */
@Data
@TableName("user_budget")
public class UserBudget {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 
     */
    @TableField("category_type")
    private Byte categoryType;

    /**
     * 
     */
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    /**
     * 预算金额
     */
    @TableField("budget_amount")
    private BigDecimal budgetAmount;
    /**
     * 预算剩余
     */
    @TableField("budget_surplus")
    private BigDecimal budgetSurplus;
    /**
     * 
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 
     */
    @TableField("del_flag")
    private Byte delFlag;

}