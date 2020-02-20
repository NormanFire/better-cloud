package com.better.cloud.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lius
 * @description
 * @date 2020/2/20
 */
@Data
public class BetterUser implements Serializable {
    private static final long serialVersionUID = -1748289340320186418L;

    private String username;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;
}
