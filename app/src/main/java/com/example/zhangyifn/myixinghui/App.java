package com.example.zhangyifn.myixinghui;

import android.app.Application;
import android.util.Log;

import com.example.zhangyifn.myixinghui.di.component.AppComponent;
import com.example.zhangyifn.myixinghui.di.component.DaggerAppComponent;
import com.example.zhangyifn.myixinghui.di.module.AppModule;

import dagger.internal.DaggerCollections;

/** e
 * Created by zhangyifn on 2018/5/17.
 */

public class App extends Application{


    AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent=DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }


}
