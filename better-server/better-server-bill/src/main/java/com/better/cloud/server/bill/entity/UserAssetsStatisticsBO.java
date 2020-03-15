package com.better.cloud.server.bill.entity;


import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: Mou Yiquan
 * @create: 2020/3/15 20:40
 * @description: 用户资产统计业务对象
 **/
@Data
public class UserAssetsStatisticsBO {

    //资产列表
    private List<UserAssets> userAssetsList;

    //净资产
    private BigDecimal totalAssets;

    //正资产
    private BigDecimal positiveAssets;

    //负资产
    private BigDecimal negativeqAssets;

    public UserAssetsStatisticsBO(){
        totalAssets = BigDecimal.valueOf(0);
        totalAssets = BigDecimal.valueOf(0);
        negativeqAssets = BigDecimal.valueOf(0);
    }

    public void addPositiveAssets(BigDecimal amount) {
        if (amount != null){
            positiveAssets.add(amount);
        }
    }

    public void addNegativeqAssets(BigDecimal amount) {
        if (amount != null) {
            negativeqAssets.add(amount);
        }
    }

    public void calculateTotalAssets() {
        totalAssets = positiveAssets.add(negativeqAssets);
    }
}
