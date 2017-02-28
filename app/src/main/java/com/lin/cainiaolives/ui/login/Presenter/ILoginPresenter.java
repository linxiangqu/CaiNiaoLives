package com.lin.cainiaolives.ui.login.presenter;

/**
 * Created by Administrator on 2017/2/15.
 */

public interface ILoginPresenter {
    void login(String username, String password);

    void mobileLogin(String mobile, String verifyCode);

    void onDestroy();
}
