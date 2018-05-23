package com.example.zhangyifn.myixinghui;

import android.app.Application;

import com.example.zhangyifn.myixinghui.base.component.AppComponent;
import com.example.zhangyifn.myixinghui.base.component.DaggerAppComponent;
import com.example.zhangyifn.myixinghui.base.module.AppModule;

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
