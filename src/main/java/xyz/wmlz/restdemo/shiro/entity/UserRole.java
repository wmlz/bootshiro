package xyz.wmlz.restdemo.shiro.entity;

import java.io.Serializable;

/**
 * created by wmlz at 2018/4/17 14:55<br>
 */
public class UserRole implements Serializable {

    private Integer userId;
    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
