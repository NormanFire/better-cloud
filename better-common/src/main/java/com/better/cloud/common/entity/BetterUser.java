package com.better.cloud.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

/**
 * @author lius
 * @description
 * @date 2020/2/20
 */
@EqualsAndHashCode(callSuper = true)
public class BetterUser extends User {
    private static final long serialVersionUID = -6411066541689297219L;

    private Long userId;

    private String avatar;

    private String email;

    private String mobile;

    private String sex;

    private Long deptId;

    private String deptName;

    private String roleId;

    private String roleName;

    private Date lastLoginTime;

    private String description;

    private String status;

    public BetterUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public BetterUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BetterUser that = (BetterUser) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(avatar, that.avatar) &&
                Objects.equals(email, that.email) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(deptId, that.deptId) &&
                Objects.equals(deptName, that.deptName) &&
                Objects.equals(roleId, that.roleId) &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(lastLoginTime, that.lastLoginTime) &&
                Objects.equals(description, that.description) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, avatar, email, mobile, sex, deptId, deptName, roleId, roleName, lastLoginTime, description, status);
    }

    @Override
    public String toString() {
        return "BetterUser{" +
                "userId=" + userId +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", sex='" + sex + '\'' +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
