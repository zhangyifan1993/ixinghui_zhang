package com.example.zhangyifn.myixinghui.bean.login;

/**
 * Created by zhangyifn on 2018/5/23.
 */

public class UserMedal {
    private String medalId;  // 1 是专家 2 是老师
    private String medalName;
    private String medalLevel;

    public String getMedalId() {
        return medalId;
    }

    public void setMedalId(String medalId) {
        this.medalId = medalId;
    }

    public String getMedalName() {
        return medalName;
    }

    public void setMedalName(String medalName) {
        this.medalName = medalName;
    }

    public String getMedalLevel() {
        return medalLevel;
    }

    public void setMedalLevel(String medalLevel) {
        this.medalLevel = medalLevel;
    }

}
