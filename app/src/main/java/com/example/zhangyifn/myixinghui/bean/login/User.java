package com.example.zhangyifn.myixinghui.bean.login;

import java.util.List;

/**
 * Created by zhangyifn on 2018/5/23.
 */

public class User {
    public String getHxpwd() {
        return hxpwd;
    }

    public void setHxpwd(String hxpwd) {
        this.hxpwd = hxpwd;
    }

    private String hxpwd;
    private String name;
    private String userId;
    private String headURL;
    private String phoneNo;
    private String sex;

    public List<UserMedal> getUserMedalList() {
        return userMedalList;
    }

    public void setUserMedalList(List<UserMedal> userMedalList) {
        this.userMedalList = userMedalList;
    }

    private List<UserMedal> userMedalList;



    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHeadURL() {
        return headURL;
    }

    public void setHeadURL(String headURL) {
        this.headURL = headURL;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", headURL='" + headURL + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
