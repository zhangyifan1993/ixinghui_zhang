package com.example.zhangyifn.myixinghui.ui.login;

import com.example.zhangyifn.myixinghui.base.basemvp.BaseView;
import com.example.zhangyifn.myixinghui.bean.login.LoginResponseBean;

/**
 * Created by zhangyifn on 2018/5/23.
 */

public interface ILoginView extends BaseView {

      void loginByPassWord(LoginResponseBean bean);

}
