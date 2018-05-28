package com.example.zhangyifn.myixinghui.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhangyifn.myixinghui.App;
import com.example.zhangyifn.myixinghui.R;
import com.example.zhangyifn.myixinghui.base.basemvp.BaseFragment;
import com.example.zhangyifn.myixinghui.bean.login.LoginResponseBean;
import com.example.zhangyifn.myixinghui.ui.login.ILoginView;
import com.example.zhangyifn.myixinghui.ui.login.LoginPresenter;
import com.example.zhangyifn.myixinghui.utils.MD5;

/**
 * Created by zhangyifn on 2018/5/23.
 */

public class LoginFragment extends BaseFragment<ILoginView,LoginPresenter> implements ILoginView {

    @Override
    protected View getView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login,null);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initUI() {
        View viewById = getRootView().findViewById(R.id.login);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LoginPresenter)getPresenter()).loginByPassword("13037166378", MD5.md5("8885035z"),"");
            }
        });
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter((App) getActivity().getApplication());
    }

    @Override
    public void loginByPassWord(LoginResponseBean bean) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }
}
