package com.better.cloud.server.bill.enums;

/**
 * @Author ctbum
 * @Email
 * @Date 21:15 2020/3/15
 * @Description //账户类型
**/
public enum AssetsTypeEnum {
    //存款账户
    POSITIVE_ACCOUNT(0,"POSITIVE_ACCOUNT"),
    //负债账户
    NEGATIVEQ_ACCOUNT(1,"NEGATIVEQ_ACCOUNT");
    /**
     * 账户类型编码
     */
    private int typeCode;
    /**
     * 账户类型名称
     */
    private String typeName;

    private AssetsTypeEnum(int typeCode,String typeName){
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
