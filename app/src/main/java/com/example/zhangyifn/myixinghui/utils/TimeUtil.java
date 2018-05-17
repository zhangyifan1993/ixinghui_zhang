package com.example.zhangyifn.myixinghui.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ycs on 2017/1/10.
 */

public class TimeUtil {
    /*
    *计算time2减去time1的差值 差值只设置 几天 几个小时 或 几分钟
    * 根据差值返回多长之间前或多长时间后
    * */
    public static String getDistanceTime(long time1, long time2) {
        Log.i("YCS", "getDistanceTime: time1:" + time1 + "time2:" + time2
        );
        long year = 0;
        long month = 0;
        long week = 0;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        long diff = 0;
        String flag;
        if (time1 < time2) {
            diff = time2 - time1;
            Log.i("YCS", "getDistanceTime: diff:" + diff);
            flag = "前";
        } else {
            diff = time1 - time2;
            flag = "后";
        }
        day = diff / (24 * 60 * 60 * 1000);
        hour = (diff / (60 * 60 * 1000) - day * 24);
        min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
        sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        Log.e("TAG", "周Time: "+ day +"  "+hour+"  "+min+"  "+sec);
        if (day > 0 && day < 7) {
            return day + "天" + flag;
        } else if (day >= 7 && day < 30) {
            int temp = (int) (day / 7);
            return temp + "周" + flag;
        } else if (day >= 30 && day < 365) {
            int temp = (int) (day / 30);
            return temp + "月" + flag;
        } else if (day >= 365) {
            int temp = (int) (day / 365);
            return temp + "年" + flag;
        }
        if (hour != 0) return hour + "小时" + flag;
        if (min != 0) return min + "分钟" + flag;
        return "刚刚";
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static long getCurrentTime() {
        long time = System.currentTimeMillis();
        return time;
    }

    public static long stringToLong(String strTime, String formatType)
            throws ParseException {
        Date date = stringToDate(strTime, formatType); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }

    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    public static long dateToLong(Date date) {
        return date.getTime();
    }

    public static String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd HH点mm分ss秒");
        String startTime = sdf.format(date);
        return startTime;
    }

    /**
     *功能：返回年
     *
     *@paramdate
     *@return
     */
    public static int getYear(Date date){
        if(date==null){
            date=new Date();
        }
        Calendar c= Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);

    }

    /**
     *功能：返回月
     *
     *@paramdate
     *@return
     */
    public static int getMonth(Date date){
        if(date==null){
            date=new Date();
        }
        Calendar c= Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH)+1;
    }

    /**
     *功能：返回日
     *
     *@paramdate
     *@return
     */
    public static int getDay(Date date){
        if(date==null){
            date=new Date();
        }
        Calendar c= Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }
}

