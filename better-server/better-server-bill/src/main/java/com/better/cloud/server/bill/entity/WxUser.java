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
 * @date 2020-03-08 09:58:03
 */
@Data
@TableName("wx_user")
public class WxUser {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField("openid")
    private String openid;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 性别（0：未知，1：男性，2：女性）
     */
    @TableField("sex")
    private Byte sex;

    /**
     * 用户的语言
     */
    @TableField("language")
    private String language;

    /**
     * 所在城市
     */
    @TableField("city")
    private String city;

    /**
     * 所在省份
     */
    @TableField("province")
    private String province;

    /**
     * 所在国家
     */
    @TableField("country")
    private String country;

    /**
     * 用户头像
     */
    @TableField("headimgurl")
    private String headimgurl;

    /**
     * 关注状态（0：未关注，1：关注）未关注获取不到信息
     */
    @TableField("subscribe")
    private Byte subscribe;

    /**
     * 关注时间
     */
    @TableField("subscribe_time")
    private Date subscribeTime;

    /**
     * 删除标记（0：存在，1：删除）
     */
    @TableField("del_flag")
    private Byte delFlag;

}