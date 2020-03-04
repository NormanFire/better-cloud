package com.better.cloud.common.entity.wiki;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 空间表 Entity
 *
 * @author better
 * @date 2020-02-28 19:04:36
 */
@Data
@TableName("t_space")
public class Space {

    /**
     * 空间 id
     */
    @TableId(value = "space_id", type = IdType.AUTO)
    private Integer spaceId;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    /**
     * 标签
     */
    @TableField("tags")
    private String tags;

    /**
     * 访问级别：private,public
     */
    @TableField("visit_level")
    private Integer visitLevel;
    /**
     * 文档是否允许分享 0 否 1 是
     */
    @TableField("is_share")
    private Integer isShare;

    /**
     * 文档是否允许导出 0 否 1 是
     */
    @TableField("is_export")
    private Integer isExport;

    /**
     * 是否删除 0 否 1 是
     */
    @TableField("is_delete")
    private Integer isDelete;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

}