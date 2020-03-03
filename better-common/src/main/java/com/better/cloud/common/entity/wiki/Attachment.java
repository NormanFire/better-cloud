package com.better.cloud.common.entity.wiki;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 附件信息表 Entity
 *
 * @author better
 * @date 2020-02-28 19:05:04
 */
@Data
@TableName("t_attachment")
public class Attachment {

    /**
     * 附件 id
     */
    @TableId(value = "attachment_id", type = IdType.AUTO)
    private Integer attachmentId;

    /**
     * 创建用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 所属文档id
     */
    @TableField("document_id")
    private Integer documentId;

    /**
     * 附件名称
     */
    @TableField("name")
    private String name;

    /**
     * 附件路径
     */
    @TableField("path")
    private String path;

    /**
     * 附件来源， 0 默认是附件 1 图片
     */
    @TableField("source")
    private Integer source;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Integer createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Integer updateTime;

}