package com.lin.cainiaolives.ui.register;

import android.content.Context;

import com.lin.cainiaolives.http.APIFactory;
import com.lin.cainiaolives.http.ProgressSubscriber;
import com.lin.cainiaolives.http.SubscriberOnNextListener;
import com.lin.cainiaolives.ui.register.bean.MobileRegister;
import com.lin.cainiaolives.ui.register.bean.MobileRegister_CS;
import com.lin.cainiaolives.ui.register.bean.Register;
import com.lin.cainiaolives.ui.register.bean.Register_CS;
import com.lin.cainiaolives.utilcode.RegexUtils;
import com.lin.cainiaolives.utilcode.ToastUtils;

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
    public int GetVerificationCode() {

        return 1111;
    }
}