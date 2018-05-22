package com.example.zhangyifn.myixinghui.di.module;

import android.content.Context;

import com.example.zhangyifn.myixinghui.Protocol;
import com.example.zhangyifn.myixinghui.http.APIService;
import com.example.zhangyifn.myixinghui.http.HttpLoggingInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangyifn on 2018/5/22.
 */

@Module
public class AppModule {
    //连接超时
    private static final long OUTTIME = 10;
    String baseUrl= Protocol.CLIENT_HOST_URL;
    private Context context;

    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();




    public AppModule(Context context) {
        this.context = context;
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    //提供Retrofit
    @Provides
    @Singleton
    public Retrofit provideRetrofit(){
        return  new  Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(provideOkhttpClient()).build();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkhttpClient() {
        return new OkHttpClient.Builder()
                .writeTimeout(OUTTIME, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .readTimeout(OUTTIME, TimeUnit.SECONDS)
                .connectTimeout(OUTTIME, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return  context;
    }

    //提供网络请求的接口
    @Provides
    @Singleton
    public APIService provideAPIService(){
        return provideRetrofit().create(APIService.class);
    }

}
