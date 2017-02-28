package com.lin.cainiaolives.ui.login.model;

import com.lin.cainiaolives.ui.login.OnLoginListener;
import com.lin.cainiaolives.ui.login.bean.Login_CS;
import com.lin.cainiaolives.ui.login.bean.MobileLogin_CS;

/**
* Created by Administrator on 2017/02/15
*/

public interface ILoginModel{
    void usernameLogin(Login_CS login_cs, OnLoginListener listener);

    void mobilephoneLogin(MobileLogin_CS mobileLogin_cs, OnLoginListener listener);
}