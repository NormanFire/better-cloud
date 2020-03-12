package com.better.cloud.server.bill.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.hibernate.validator.constraints.Length;

/**
 *  Entity
 *
 * @author better
 * @date 2020-03-08 09:58:49
 */
@Data
@TableName("user_feedback")
public class UserFeedback {

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
     * 类型（0：其它，1：程序错误，2：功能建议）
     */
    @TableField("type")
    private Byte type;

    /**
     * 内容
     */
    @TableField("content")
    @Length(max = 500)
    private String content;

    /**
     * 备注
     */
    @TableField("note")
    private String note;

    /**
     * 状态：（0：新建，1：处理中，2：完成，3：拒绝）
     */
    @TableField("status")
    private Byte status;

    /**
     * 
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 处理完成时间
     */
    @TableField("deal_time")
    private Date dealTime;

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