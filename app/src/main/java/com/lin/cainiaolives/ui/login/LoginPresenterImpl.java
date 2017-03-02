package com.lin.cainiaolives.ui.login;

import android.content.Context;

import com.lin.cainiaolives.http.APIFactory;
import com.lin.cainiaolives.http.ProgressSubscriber;
import com.lin.cainiaolives.http.SubscriberOnNextListener;
import com.lin.cainiaolives.ui.login.bean.Login;
import com.lin.cainiaolives.ui.login.bean.Login_CS;
import com.lin.cainiaolives.ui.login.bean.MobileLogin;
import com.lin.cainiaolives.ui.login.bean.MobileLogin_CS;
import com.lin.cainiaolives.utilcode.RegexUtils;
import com.lin.cainiaolives.utilcode.ToastUtils;

/**
 * Created by Administrator on 2017/3/1.
 */

public class LoginPresenterImpl implements ILoginContract.ILoginPresenter {
    private APIFactory retrofitUtil;
    private Context mContext;
    private ILoginContract.ILoginView mILoginView;

    public LoginPresenterImpl(APIFactory retrofitUtil, Context context, ILoginContract.ILoginView mILoginView) {
        this.retrofitUtil = retrofitUtil;
        this.mContext = context;
        this.mILoginView = mILoginView;
    }

    @Override
    public void Login(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            mILoginView.LoginError("请填写全部信息");
            return;
        }
        Login_CS login_cs = new Login_CS();
        login_cs.setAction("login");
        login_cs.setUserName(username);
        login_cs.setPassword(password);
        retrofitUtil.getLogin(new ProgressSubscriber<Login>(new SubscriberOnNextListener<Login>() {
            @Override
            public void onNext(Login login) {
                if (login.getStatus() == 0) {
                    ToastUtils.showShortToast(login.getMsg());
                    mILoginView.LoginSuccess();
                } else
                    ToastUtils.showShortToast(login.getMsg());
            }

            @Override
            public void onError(int code, String message) {
                mILoginView.LoginError(message);
            }
        }, mContext, true), login_cs);
    }

    @Override
    public void Login_Mobile(String mobilephone, String verificationcode) {
        if (mobilephone.isEmpty() || verificationcode.isEmpty()) {
            mILoginView.LoginError("请填写全部信息");
            return;
        }
        if (!RegexUtils.isMobileExact(mobilephone)) {
            mILoginView.LoginError("请输入正确的手机号码");
            return;
        }
        MobileLogin_CS mobileLogin_cs = new MobileLogin_CS();
        mobileLogin_cs.setAction("phoneLogin");
        mobileLogin_cs.setMobile(mobilephone);
        mobileLogin_cs.setVerifyCode(verificationcode);
        retrofitUtil.getMobileLogin(new ProgressSubscriber<MobileLogin>(new SubscriberOnNextListener<MobileLogin>() {
            @Override
            public void onNext(MobileLogin mobileLogin) {
                if (mobileLogin.getStatus() == 0) {
                    ToastUtils.showShortToast(mobileLogin.getMsg());
                    mILoginView.LoginSuccess();
                } else
                    ToastUtils.showShortToast(mobileLogin.getMsg());
            }

            @Override
            public void onError(int code, String message) {
                mILoginView.LoginError(message);
            }
        }, mContext, true), mobileLogin_cs);

    }

    @Override
    public int GetVerificationCode() {

        return 1111;
    }
}