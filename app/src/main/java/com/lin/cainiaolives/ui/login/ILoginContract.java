package com.lin.cainiaolives.ui.login;

/**
 * Created by Administrator on 2017/3/1.
 */

public interface ILoginContract {
    interface ILoginView {
        void LoginSuccess();

        void LoginError(String msg);
    }

    interface ILoginPresenter {
        void Login(String username, String password);

        void Login_Mobile(String mobilephone, String verificationcode);

        int GetVerificationCode();
    }
}
