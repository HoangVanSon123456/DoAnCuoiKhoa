package com.example.doancuoikhoa.utils;

public enum  RoleEnum {
    ADMIN(1, "ROLE_ADMIN") , MEMBER(2, "ROLE_MEMBER"),TEACHER(3, "TEACHER") , STUDENT(4, "STUDENT");;
    private int roleId;
    private String roleName;

    RoleEnum(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
