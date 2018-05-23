package com.example.zhangyifn.myixinghui.base.basemvp;

import com.example.zhangyifn.myixinghui.App;
import com.example.zhangyifn.myixinghui.base.component.AppComponent;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import javax.inject.Inject;

/**
 * Created by zhangyifn on 2018/5/23.
 */

public class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {




    private App app;

    public AppComponent getmAppComponent() {
        return mAppComponent;
    }

    private AppComponent mAppComponent;

    @Inject
    public BasePresenter(App app) {
        this.app = app;
        mAppComponent=app.getAppComponent();
    }


    public App getApp() {
        return app;
    }

}
