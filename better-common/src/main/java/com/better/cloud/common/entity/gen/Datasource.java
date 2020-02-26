package com.better.cloud.common.entity.gen;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author better
 * @date 2020-02-23 21:39:53
 */
@Data
@TableName("t_datasource")
public class Datasource {

    /**
     * 
     */
    @TableId(value = "GEN_ID", type = IdType.AUTO)
    private Long genId;

    /**
     * 数据源名称
     */
    @TableField("DATASOURCE_NAME")
    private String datasourceName;

    /**
     * 连接url
     */
    @TableField("JDBC_URL")
    private String jdbcUrl;

    /**
     * 数据库用户名
     */
    @TableField("USERNAME")
    private String username;

    /**
     * 数据库密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 数据库类型 0 mysql 1 oracle 2 sqlserver
     */
    @TableField("TYPE")
    private Integer type;

}