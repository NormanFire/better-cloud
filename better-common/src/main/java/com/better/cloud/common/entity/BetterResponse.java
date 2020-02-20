package com.better.cloud.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

/**
 * @author lius
 * @description 自定义响应体
 * @date 2020/2/20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BetterResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public BetterResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public BetterResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public BetterResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public String getMessage() {
        return String.valueOf(get("message"));
    }

    public Object getData() {
        return get("data");
    }
}
