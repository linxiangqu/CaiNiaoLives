package com.lin.cainiaolives.http;


import com.lin.cainiaolives.ui.login.bean.Login;
import com.lin.cainiaolives.ui.login.bean.Login_CS;
import com.lin.cainiaolives.ui.login.bean.MobileLogin;
import com.lin.cainiaolives.ui.login.bean.MobileLogin_CS;
import com.lin.cainiaolives.ui.login.bean.VerifyCode;
import com.lin.cainiaolives.ui.login.bean.VerifyCode_CS;
import com.lin.cainiaolives.ui.register.bean.MobileRegister;
import com.lin.cainiaolives.ui.register.bean.MobileRegister_CS;
import com.lin.cainiaolives.ui.register.bean.Register;
import com.lin.cainiaolives.ui.register.bean.Register_CS;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by linxiangqu on 2016/11/3.
 */
public class APIFactory extends RetrofitUtil {
    public volatile static APIFactory apiFactory;

    //采用单例模式获取请求
    public static APIFactory getInstance() {
        if (apiFactory == null) {
            synchronized (APIFactory.class) {
                if (apiFactory == null)
                    apiFactory = new APIFactory();
            }
        }
        return apiFactory;
    }

    //用户名登录
    public void getLogin(Subscriber<Login> subscriber, Login_CS login_cs) {
        Observable<Login> observable = retrofitApi.login(login_cs);
        toSubscribe(observable, subscriber);
    }

    //手机登录
    public void getMobileLogin(Subscriber<MobileLogin> subscriber, MobileLogin_CS mobileLogin_cs) {
        Observable<MobileLogin> observable = retrofitApi.mobileLogin(mobileLogin_cs);
        toSubscribe(observable, subscriber);
    }

    //用户名注册
    public void getRegister(Subscriber<Register> subscriber, Register_CS register_cs) {
        Observable<Register> observable = retrofitApi.register(register_cs);
        toSubscribe(observable, subscriber);
    }

    //手机号注册
    public void getMobileRegister(Subscriber<MobileRegister> subscriber, MobileRegister_CS mobileRegister_cs) {
        Observable<MobileRegister> observable = retrofitApi.mobileRegister(mobileRegister_cs);
        toSubscribe(observable, subscriber);
    }

    //获取验证码
    public void getVerifyCode(Subscriber<VerifyCode> subscriber, VerifyCode_CS verifyCode_cs) {
        Observable<VerifyCode> observable = retrofitApi.verifyCode(verifyCode_cs);
        toSubscribe(observable, subscriber);
    }
}
