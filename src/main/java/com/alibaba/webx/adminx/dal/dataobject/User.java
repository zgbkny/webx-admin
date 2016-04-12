package com.alibaba.webx.adminx.dal.dataobject;

public class User {

    public static final int TYPE_NORM = 0;
    public static final int TYPE_WECHAT = 1;

    public static final int ROLE_USER = 1;
    public static final int ROLE_ADMIN = 2;
    public static final int ROLE_ROOT = 3;

    private int      id;
	private String   username;
    private String   password;
    private String   email;
    private int      role;
    private int      type;

    public User() {}

    public User(String username, String password, String email, int type, int role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.type = type;
        this.role = role;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUserId(String username) {
        this.username = username;
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
