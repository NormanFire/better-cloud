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
 * @date 2020-03-08 09:58:43
 */
@Data
@TableName("user_bill")
public class UserBill {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 账户id
     */
    @TableId(value = "account_id", type = IdType.AUTO)
    private Integer accountId;

    /**
     * 分类类型：(0：系统分类；1：用户自定义分类)
     */
    @TableField("category_type")
    private Byte categoryType;

    /**
     * 分类id
     */
    @TableField("category_id")
    private Integer categoryId;

    /**
     * 账单类型 0：支出   1：收入
     */
    @TableField("type")
    private Byte type;

    /**
     * 金额
     */
    @TableField("amount")
    private BigDecimal amount;
    /**
     * 账单日期
     */
    @TableField("bill_date")
    private Date billDate;

    /**
     * 
     */
    @TableField("bill_address")
    private String billAddress;

    /**
     * 备注
     */
    @TableField("note")
    private String note;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 最近更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 删除标记  0：正常   1：删除
     */
    @TableField("del_flag")
    private Byte delFlag;

}