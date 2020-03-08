package com.better.cloud.server.bill.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author better
 * @date 2020-03-08 09:58:41
 */
@Data
@TableName("user_bill_category")
public class UserBillCategory {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属分类id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 分类类型（0：其它；1：支出；2：收入）
     */
    @TableId(value = "type", type = IdType.AUTO)
    private Byte type;

    /**
     * 分类名称
     */
    @TableField("name")
    private String name;

    /**
     * 是否定级分类（0：是；1：否）
     */
    @TableField("is_top")
    private Byte isTop;

    /**
     * ican的url链接
     */
    @TableField("icon_url")
    private String iconUrl;

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
     * 删除标记（0：正常；1：删除）
     */
    @TableField("del_flag")
    private Byte delFlag;

}