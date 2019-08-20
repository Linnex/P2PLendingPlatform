package com.gxa.p2p.common.pojo;

public class LoginInfo {
    public static final Byte STATE_NORMAL = 0;
    public static final int USER_MGR = 0;
    public static final int USER_WEB = 1;
    private int usertype = 0; //用户类型（前台、后台）

    private Long id;

    private String username;

    private String password;

    private Byte state;

    private int admin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
}