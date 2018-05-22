package com.example.zhangyifn.myixinghui;

/**
 * Created by zhangyifn on 2018/5/22.
 */

public class Protocol {
    public static final String CLIENT_HOST_URL;
    static {
        if (AppConfig.isDebug) {
            if (AppConfig.isQQ){
                //测试后台同学电脑花生壳
                CLIENT_HOST_URL = "http://12407.imwork.net:35445/ixinghui/";
            }else {
                //测试本地服务器
                CLIENT_HOST_URL = "http://16p73762o8.iask.in:43521/ixinghui/";
            }
        } else {
           //线上
            CLIENT_HOST_URL = "http://api.ixinghui.com:81/ixinghui/";
        }
    }

}
