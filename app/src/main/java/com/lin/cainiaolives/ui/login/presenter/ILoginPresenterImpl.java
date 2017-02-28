package com.lin.cainiaolives.ui.login.presenter;


import android.content.Context;

import com.lin.cainiaolives.http.APIFactory;
import com.lin.cainiaolives.ui.login.OnLoginListener;
import com.lin.cainiaolives.ui.login.bean.Login_CS;
import com.lin.cainiaolives.ui.login.bean.MobileLogin_CS;
import com.lin.cainiaolives.ui.login.model.ILoginModel;
import com.lin.cainiaolives.ui.login.model.ILoginModelImpl;
import com.lin.cainiaolives.ui.login.view.ILoginView;

/**
 * Created by Administrator on 2017/02/15
 */

public class ILoginPresenterImpl implements ILoginPresenter, OnLoginListener {
    private ILoginView iLoginView;
    private ILoginModel iLoginModel;

    public ILoginPresenterImpl(ILoginView iLoginView, APIFactory retrofitUtil, Context context) {
        this.iLoginView = iLoginView;
        iLoginModel = new ILoginModelImpl(retrofitUtil, context);
    }

    @Override
    public void login(String username, String password) {
        Login_CS login_cs = new Login_CS();
        login_cs.setAction("login");
        login_cs.setUserName(username);
        login_cs.setPassword(password);
        iLoginModel.usernameLogin(login_cs, this);
    }

    @Override
    public void mobileLogin(String mobile, String verifyCode) {
        MobileLogin_CS mobileLogin_cs = new MobileLogin_CS();
        mobileLogin_cs.setAction("phoneLogin");
        mobileLogin_cs.setMobile(mobile);
        mobileLogin_cs.setVerifyCode(verifyCode);
        iLoginModel.mobilephoneLogin(mobileLogin_cs, this);
    }

    @Override
    public void onDestroy() {
        iLoginView = null;
    }

    @Override
    public void success() {
        iLoginView.loginSuccess();
    }
}