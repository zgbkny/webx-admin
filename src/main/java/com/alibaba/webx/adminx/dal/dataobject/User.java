package com.alibaba.webx.adminx.dal.dataobject;

public class User {

    public static final int TYPE_NORM = 0;
    public static final int TYPE_WECHAT = 1;

    public static final int ROLE_USER = 1;
    public static final int ROLE_ADMIN = 2;
    public static final int ROLE_ROOT = 3;

	private String   userId;
    private String   password;
    private String   email;
    private int      role;
    private int      type;

    public User() {}

    public User(String userId, String password, String email, int type, int role) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.type = type;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public int getRole() {
        return this.role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
