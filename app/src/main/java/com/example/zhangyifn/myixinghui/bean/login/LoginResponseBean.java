package com.example.zhangyifn.myixinghui.bean.login;

/**
 * Created by zhangyifn on 2018/5/23.
 */

public class LoginResponseBean {
    private String token;
    private User user;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    int status;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
