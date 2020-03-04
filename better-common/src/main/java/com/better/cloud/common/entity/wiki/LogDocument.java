package com.better.cloud.common.entity.wiki;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 文档日志表 Entity
 *
 * @author better
 * @date 2020-03-04 14:49:27
 */
@Data
@TableName("t_log_document")
public class LogDocument {

    /**
     * 文档日志 id
     */
    @TableId(value = "log_document_id", type = IdType.AUTO)
    private Integer logDocumentId;

    /**
     * 文档id
     */
    @TableField("document_id")
    private Integer documentId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 动作 1 创建 2 修改 3 删除
     */
    @TableField("action")
    private Byte action;

    /**
     * 备注信息
     */
    @TableField("comment")
    private String comment;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Integer createTime;

}