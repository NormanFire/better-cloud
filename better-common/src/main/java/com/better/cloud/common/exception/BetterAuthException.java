package com.better.cloud.common.exception;

/**
 * @author lius
 * @description 自定义认证异常
 * @date 2020/2/20
 */
public class BetterAuthException extends Exception{
    private static final long serialVersionUID = -6916154462432027437L;

    public BetterAuthException(String message){
        super(message);
    }
}
