package com.lin.cainiaolives.ui.register;

import android.content.Context;

import com.lin.cainiaolives.R;
import com.lin.cainiaolives.http.APIFactory;
import com.lin.cainiaolives.http.ProgressSubscriber;
import com.lin.cainiaolives.http.SubscriberOnNextListener;
import com.lin.cainiaolives.ui.login.bean.VerifyCode;
import com.lin.cainiaolives.ui.login.bean.VerifyCode_CS;
import com.lin.cainiaolives.ui.register.bean.MobileRegister;
import com.lin.cainiaolives.ui.register.bean.MobileRegister_CS;
import com.lin.cainiaolives.ui.register.bean.Register;
import com.lin.cainiaolives.ui.register.bean.Register_CS;
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
 * Created by Administrator on 2017/3/2.
 */

public class RegisterPresenterImpl implements IRegisterContract.IRegisterPresenter {

    private Context mContext;
    private APIFactory retrofit;
    private IRegisterContract.IRegisterView mIRegisterView;

    public RegisterPresenterImpl(Context context, APIFactory retrofit, IRegisterContract.IRegisterView IRegisterView) {
        mContext = context;
        this.retrofit = retrofit;
        mIRegisterView = IRegisterView;
    }

    @Override
    public void NormalRegister(String username, String password, String repeatpassword) {
        if (username.isEmpty() || password.isEmpty() || repeatpassword.isEmpty()) {
            mIRegisterView.RegisterError("请填写全部信息");
            return;
        }
        if (!password.equals(repeatpassword)) {
            mIRegisterView.RegisterError("两次密码输入不一致，请检查！");
            return;
        }
        Register_CS register_cs = new Register_CS();
        register_cs.setAction("register");
        register_cs.setUserName(username);
        register_cs.setPassword(password);
        retrofit.getRegister(new ProgressSubscriber<Register>(new SubscriberOnNextListener<Register>() {
            @Override
            public void onNext(Register register) {
                if (register.getStatus() == 0)
                    mIRegisterView.RegisterSuccess();
                else
                    ToastUtils.showShortToast(register.getMsg());
            }

            @Override
            public void onError(int code, String message) {
                mIRegisterView.RegisterError(message);
            }
        }, mContext, true), register_cs);
    }

    @Override
    public void MobileRegister(String mobilephone, String verificationcode) {
        if (mobilephone.isEmpty() || verificationcode.isEmpty()) {
            mIRegisterView.RegisterError("请填写全部信息");
            return;
        }
        if (!RegexUtils.isMobileExact(mobilephone)) {
            mIRegisterView.RegisterError("请输入正确的手机号码");
            return;
        }
        MobileRegister_CS mobileRegister_cs = new MobileRegister_CS();
        mobileRegister_cs.setAction("phoneRegister");
        mobileRegister_cs.setMobile(mobilephone);
        mobileRegister_cs.setVerifyCode(verificationcode);
        retrofit.getMobileRegister(new ProgressSubscriber<MobileRegister>(new SubscriberOnNextListener<MobileRegister>() {
            @Override
            public void onNext(MobileRegister mobileRegister) {
                if (mobileRegister.getStatus() == 0)
                    mIRegisterView.RegisterSuccess();
                else
                    ToastUtils.showShortToast(mobileRegister.getMsg());
            }

            @Override
            public void onError(int code, String message) {
                mIRegisterView.RegisterError(message);
            }
        }, mContext, true), mobileRegister_cs);
    }

    @Override
    public boolean GetVerificationCode(final String phoneNumber) {
        if (!RegexUtils.isMobileExact(phoneNumber)) {
            mIRegisterView.RegisterError("请输入正确的手机号码");
            return false;
        }
        final int number = 60;
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(61)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        return number - aLong;
                    }
                })
                .subscribeOn(Schedulers.computation())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        VerifyCode_CS verifyCode_cs = new VerifyCode_CS();
                        verifyCode_cs.setAction("verifyCode");
                        verifyCode_cs.setMobile(phoneNumber);
                        retrofit.getVerifyCode(new ProgressSubscriber<VerifyCode>(new SubscriberOnNextListener<VerifyCode>() {
                            @Override
                            public void onNext(VerifyCode verifyCode) {
                                ToastUtils.showShortToast(verifyCode.getMsg());
                            }

                            @Override
                            public void onError(int code, String message) {
                                mIRegisterView.RegisterError(message);
                            }
                        }, mContext, false), verifyCode_cs);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIRegisterView.SetButtonEnable(false);
                    }
                })
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {
                        mIRegisterView.SetButtonEnable(true);
                        mIRegisterView.SetButtonText(mContext.getResources().getString(R.string.VerificationCode));
                    }

                    @Override
                    public void onError(Throwable e) {
                        mIRegisterView.SetButtonText(e.toString());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        mIRegisterView.SetButtonText(aLong.toString() + "秒");
                    }
                });
        return false;
    }
}