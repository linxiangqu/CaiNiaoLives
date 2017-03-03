package com.lin.cainiaolives.ui.login;

import android.content.Context;

import com.lin.cainiaolives.R;
import com.lin.cainiaolives.http.APIFactory;
import com.lin.cainiaolives.http.ProgressSubscriber;
import com.lin.cainiaolives.http.SubscriberOnNextListener;
import com.lin.cainiaolives.ui.login.bean.Login;
import com.lin.cainiaolives.ui.login.bean.Login_CS;
import com.lin.cainiaolives.ui.login.bean.MobileLogin;
import com.lin.cainiaolives.ui.login.bean.MobileLogin_CS;
import com.lin.cainiaolives.ui.login.bean.VerifyCode;
import com.lin.cainiaolives.ui.login.bean.VerifyCode_CS;
import com.lin.cainiaolives.utilcode.RegexUtils;
import com.lin.cainiaolives.utilcode.ToastUtils;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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
    public boolean GetVerificationCode(final String phoneNumber) {
        if (!RegexUtils.isMobileExact(phoneNumber)) {
            mILoginView.LoginError("请输入正确的手机号码");
            return false;
        }
        final int time = 60;
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(61)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        return time - aLong;
                    }
                })
                .subscribeOn(Schedulers.computation())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        VerifyCode_CS verifyCode_cs = new VerifyCode_CS();
                        verifyCode_cs.setAction("verifyCode");
                        verifyCode_cs.setMobile(phoneNumber);
                        retrofitUtil.getVerifyCode(new ProgressSubscriber<VerifyCode>(new SubscriberOnNextListener<VerifyCode>() {
                            @Override
                            public void onNext(VerifyCode verifyCode) {
                                ToastUtils.showShortToast(verifyCode.getMsg());
                            }

                            @Override
                            public void onError(int code, String message) {
                                mILoginView.LoginError(message);
                            }
                        }, mContext, false), verifyCode_cs);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mILoginView.SetButtonEnable(false);
                    }
                })
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {
                        mILoginView.SetButtonEnable(true);
                        mILoginView.SetButtonText(mContext.getResources().getString(R.string.VerificationCode));
                    }

                    @Override
                    public void onError(Throwable e) {
                        mILoginView.LoginError(e.toString());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        mILoginView.SetButtonText(aLong.toString() + "秒");
                    }
                });
        return false;
    }
}