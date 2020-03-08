package com.better.cloud.common.entity.bill;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *  Entity
 *
 * @author better
 * @date 2020-03-08 09:58:48
 */
@Data
@TableName("user_sys_bill_category")
public class UserSysBillCategory {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    /**
     * 
     */
    @TableId(value = "bill_id", type = IdType.AUTO)
    private Integer billId;

}