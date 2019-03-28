package com.itheima.utils;

public class RPInfo {
    private String roleId;
    private String permissionId;

    public RPInfo(String roleId, String permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "RPInfo{" +
                "roleId='" + roleId + '\'' +
                ", permissionId='" + permissionId + '\'' +
                '}';
    }
}
