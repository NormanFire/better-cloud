package com.better.cloud.common.entity.wiki;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 文档表 Entity
 *
 * @author better
 * @date 2020-02-28 19:04:26
 */
@Data
@TableName("t_document")
public class Document {

    /**
     * 文档 id
     */
    @TableId(value = "document_id", type = IdType.AUTO)
    private Integer documentId;

    /**
     * 文档父 id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 空间id
     */
    @TableField("space_id")
    private Integer spaceId;

    /**
     * 文档名称
     */
    @TableField("name")
    private String name;

    /**
     * 文档类型 1 page 2 dir
     */
    @TableField("type")
    private Integer type;

    /**
     * 存储根文档到父文档的 document_id 值, 格式 0,1,2,...
     */
    @TableField("path")
    private String path;

    /**
     * 排序号(越小越靠前)
     */
    @TableField("sequence")
    private Integer sequence;

    /**
     * 创建用户 id
     */
    @TableField("create_user_id")
    private Integer createUserId;

    /**
     * 最后修改用户 id
     */
    @TableField("edit_user_id")
    private Integer editUserId;

    /**
     * 是否删除 0 否 1 是
     */
    @TableField("is_delete")
    private Integer isDelete;

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