package com.example.zhangyifn.myixinghui.di.component;

import android.content.Context;

import com.example.zhangyifn.myixinghui.di.module.AppModule;
import com.example.zhangyifn.myixinghui.http.APIService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhangyifn on 2018/5/22.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Context getContext();

    APIService getApiService();


}
