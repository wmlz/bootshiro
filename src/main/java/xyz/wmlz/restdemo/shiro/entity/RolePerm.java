package xyz.wmlz.restdemo.shiro.entity;

import java.io.Serializable;

/**
 * created by wmlz at 2018/4/17 14:55<br>
 */
public class RolePerm implements Serializable {

    private Integer roleId;
    private Integer permId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }
}
