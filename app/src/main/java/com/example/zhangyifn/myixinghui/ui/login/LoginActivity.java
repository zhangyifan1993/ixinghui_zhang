package com.example.zhangyifn.myixinghui.ui.login;

import android.os.Bundle;

import com.example.zhangyifn.myixinghui.R;
import com.example.zhangyifn.myixinghui.base.basemvp.BaseActicity;

public class LoginActivity extends BaseActicity {

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initUi() {
         loginFragment =new LoginFragment();
         replaceFragment(R.id.fragmentContent,loginFragment);
    }

    @Override
    protected int getRootViewId() {
        return R.layout.activity_login;
    }
}
