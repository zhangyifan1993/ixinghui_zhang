package com.example.zhangyifn.myixinghui.ui.login;

import android.util.Log;

import com.example.zhangyifn.myixinghui.App;
import com.example.zhangyifn.myixinghui.base.basemvp.BasePresenter;
import com.example.zhangyifn.myixinghui.bean.login.LoginResponseBean;
import com.example.zhangyifn.myixinghui.http.MDBaseRequestMap;

import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhangyifn on 2018/5/23.
 */

public class LoginPresenter extends BasePresenter<ILoginView> {


    public LoginPresenter(App app) {
        super(app);
    }

    public void loginByPassword(String username, String pwd, String deviceToken){
        Map map=new HashMap();
        map.put("phoneNo",username);
        map.put("password",pwd);
        map.put("deviceToken","");
        map.put("phoneType","android");
        MDBaseRequestMap hashMap = new MDBaseRequestMap(map);
        if (isViewAttached()){
            getView().showProgress();
            getApp().getAppComponent().
                    getApiService().
                    loginByPassword(hashMap)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<LoginResponseBean>() {
                        @Override
                        public void onCompleted() {
                            if (isViewAttached()){
                                getView().onCompleted();
                            }

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("TAG", "onError: 1 " );
                            if (isViewAttached())
                            getView().onError(e);
                        }

                        @Override
                        public void onNext(LoginResponseBean loginResponseBean) {
                            Log.e("TAG", "onError: 2 " +loginResponseBean.getUser());
                                if (isViewAttached()){
                                    getView().loginByPassWord(loginResponseBean);
                                }
                        }
                    });
        }

    }
}
