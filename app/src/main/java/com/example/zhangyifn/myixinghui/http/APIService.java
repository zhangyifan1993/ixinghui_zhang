package com.example.zhangyifn.myixinghui.http;

import com.example.zhangyifn.myixinghui.bean.login.LoginResponseBean;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zhangyifn on 2018/5/22.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("app/login")
    Observable<LoginResponseBean> loginByPassword(
            @FieldMap Map<String,String> map

    );




}
