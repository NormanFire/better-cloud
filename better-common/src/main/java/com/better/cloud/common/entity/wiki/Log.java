package com.better.cloud.common.entity.wiki;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 系统操作日志表 Entity
 *
 * @author better
 * @date 2020-02-28 19:04:44
 */
@Data
@TableName("t_log")
public class Log {

    /**
     * 系统操作日志 id
     */
    @TableId(value = "log_id", type = IdType.UUID)
    private String logId;

    /**
     * 日志级别
     */
    @TableField("level")
    private Byte level;

    /**
     * 请求路径
     */
    @TableField("path")
    private String path;

    /**
     * get参数
     */
    @TableField("method")
    private String method;

    /**
     * post参数
     */
    @TableField("params")
    private String params;

    /**
     * 信息
     */
    @TableField("message")
    private String message;

    /**
     * ip地址
     */
    @TableField("ip")
    private String ip;

    /**
     * 用户代理
     */
    @TableField("user_agent")
    private String userAgent;

    /**
     * referer
     */
    @TableField("referer")
    private String referer;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Integer createTime;

}