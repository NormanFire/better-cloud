package com.better.cloud.common.utils;

import com.alibaba.fastjson.JSON;

/**
 * @author: Mou Yiquan
 * @create: 2020/3/8 11:10
 * @description: String and Bean transfer util
 **/
public class StringBeanUtil {

    public static <T> T stringToBean(String str,Class<T> clazz) {
        if (str == null || str.length() == 0 || clazz == null){
            return null;
        }
        if (clazz == int.class || clazz == Integer.class){
            return (T)Integer.valueOf(str);
        }else if(clazz == String.class){
            return (T)str;
        }else if(clazz == long.class || clazz == Long.class){
            return (T)Long.valueOf(str);
        }else {
            return JSON.toJavaObject(JSON.parseObject(str),clazz);
        }
    }

    public static <T> String beanToString(T value) {
        if (value == null){
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class){
            return "" + value;
        }else if(clazz == String.class){
            return (String)value;
        }else if(clazz == long.class || clazz == Long.class){
            return ""+value;
        }else {
            return JSON.toJSONString(value);
        }
    }

}
