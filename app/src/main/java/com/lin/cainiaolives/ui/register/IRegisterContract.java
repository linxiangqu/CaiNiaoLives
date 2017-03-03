package com.lin.cainiaolives.ui.register;

/**
 * Created by Administrator on 2017/3/2.
 */

public interface IRegisterContract {
    interface IRegisterView {
        void RegisterSuccess();

        void RegisterError(String msg);

        void SetButtonEnable(boolean enable);

        void SetButtonText(String msg);
    }

    interface IRegisterPresenter {
        void NormalRegister(String username, String password, String repeatpassword);

        void MobileRegister(String mobilephone, String verificationcode);

        boolean GetVerificationCode(String phoneNumber);
    }
}
