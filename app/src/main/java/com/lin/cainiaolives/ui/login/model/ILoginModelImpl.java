package com.lin.cainiaolives.ui.login.model;

import android.content.Context;

import com.lin.cainiaolives.http.APIFactory;
import com.lin.cainiaolives.http.ProgressSubscriber;
import com.lin.cainiaolives.http.SubscriberOnNextListener;
import com.lin.cainiaolives.ui.login.OnLoginListener;
import com.lin.cainiaolives.ui.login.bean.Login;
import com.lin.cainiaolives.ui.login.bean.Login_CS;
import com.lin.cainiaolives.ui.login.bean.MobileLogin;
import com.lin.cainiaolives.ui.login.bean.MobileLogin_CS;
import com.lin.cainiaolives.utilcode.ToastUtils;

/**
 * Created by Administrator on 2017/02/15
 */

public class ILoginModelImpl implements ILoginModel {
    private APIFactory retrofitUtil;
    private Context mContext;

    public ILoginModelImpl(APIFactory retrofitUtil, Context context) {
        this.retrofitUtil = retrofitUtil;
        this.mContext = context;
    }

    @Override
    public void usernameLogin(Login_CS login_cs, final OnLoginListener listener) {
        retrofitUtil.getLogin(new ProgressSubscriber<Login>(new SubscriberOnNextListener<Login>() {
            @Override
            public void onNext(Login login) {
                if (login.getStatus() == 0) {
                    ToastUtils.showShortToast(login.getMsg());
                    listener.success();
                } else
                    ToastUtils.showShortToast(login.getMsg());
            }

            @Override
            public void onError(int code, String message) {
                ToastUtils.showShortToast(message);
            }
        }, mContext, true), login_cs);
    }

    @Override
    public void mobilephoneLogin(MobileLogin_CS mobileLogin_cs, final OnLoginListener listener) {
        retrofitUtil.getMobileLogin(new ProgressSubscriber<MobileLogin>(new SubscriberOnNextListener<MobileLogin>() {
            @Override
            public void onNext(MobileLogin mobileLogin) {
                if (mobileLogin.getStatus() == 0) {
                    ToastUtils.showShortToast(mobileLogin.getMsg());
                    listener.success();
                } else
                    ToastUtils.showShortToast(mobileLogin.getMsg());
            }

            @Override
            public void onError(int code, String message) {
                ToastUtils.showShortToast(message);
            }
        }, mContext, true), mobileLogin_cs);
    }
}