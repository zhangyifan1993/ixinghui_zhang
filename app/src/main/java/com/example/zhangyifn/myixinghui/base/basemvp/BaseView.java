package com.example.zhangyifn.myixinghui.base.basemvp;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by zhangyifn on 2018/5/23.
 */

public interface BaseView extends MvpView {
    void showProgress();

    void onCompleted();

    void onError(Throwable e);
}
