package com.charles.bank.entity;

/**
 * 管理员类型表
 * Created by chaersi on 2017/7/17.
 */
public class ManagerLevel {
    /**
     * managerLevel:管理员等级
     * permission：权限
      */
    private int managerLevel;
    private String permission;

    public ManagerLevel() {
    }

    public ManagerLevel(int managerLevel, String permission) {

        this.managerLevel = managerLevel;
        this.permission = permission;
    }

    public int getManagerLevel() {
        return managerLevel;
    }

    public void setManagerLevel(int managerLevel) {
        this.managerLevel = managerLevel;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "管理员类型信息{" +
                "managerLevel=" + managerLevel +
                ", permission='" + permission + '\'' +
                '}';
    }
}
