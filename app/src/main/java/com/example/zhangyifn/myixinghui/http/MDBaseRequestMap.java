package com.example.zhangyifn.myixinghui.http;

import android.text.TextUtils;

import com.example.zhangyifn.myixinghui.AppConfig;
import com.example.zhangyifn.myixinghui.utils.MD5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;


/**
 * Created by ycs on 2016/6/17.
 */
public class MDBaseRequestMap extends MDBasicRequestMap {
    public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public MDBaseRequestMap(Map map) {
        super(map);
        this.put("timestamp", getTimestamp());
        this.put("rand", getRand(16));
        this.put("app_id", getApp_id());
        this.put("ver", getVer());
        this.put("plat",  getPlat());
        String token=null;
        if (!TextUtils.isEmpty(token)) {
            this.put("token", token);
        }
//        if (UserHelper.getHelper().getToken() != null) {
//            this.put("token", UserHelper.getHelper().getToken());
//        }
        this.put("sign", getSignString());
    }

    /**
     * 获取缓存到本地的 app_id
     *
     * @return
     */
    private String getApp_id() {
        String app_id = AppConfig.APP_ID;
        return app_id;
    }

    /**
     * 获取时间戳
     *
     * @return
     */
    private String getTimestamp() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss:SSS");
        String timestamp = format.format(new Date());
        return timestamp;
    }

    private String getSignString() {
        Map<String, String> map = new TreeMap<>();
        map.putAll(this);
        map.put("private_key", this.getPrivate_key());
        StringBuilder sb = new StringBuilder();
        for (String o : map.keySet()) {
            if (sb.length() == 0) {
                sb.append(o + "=" + map.get(o));
            } else {
                sb.append("&").append(o + "=" + map.get(o));
            }
        }

        return MD5.md5(sb.toString());
    }

    private String getVer() {
        try {
            return "1.0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AppConfig.VER;
    }

    private String getPrivate_key() {
        return AppConfig.PRIVATE_KEY;
    }

    private String getPlat() {
        return AppConfig.PLAT;
    }

    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    private String getRand(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int maxLen = ALLCHAR.length();
        for (int i = 0; i < length; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(maxLen * 4) % maxLen));
        }
        return sb.toString();
    }
}
