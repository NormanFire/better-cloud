package com.better.cloud.common.exception;

/**
 * @author lius
 * @description
 * @date 2020/2/20
 */
public class ValidateCodeException extends Exception{

    private static final long serialVersionUID = 7514854456967620043L;

    public ValidateCodeException(String message){
        super(message);
    }
}