package com.lin.cainiaolives.http;


import com.lin.cainiaolives.ui.login.bean.Login;
import com.lin.cainiaolives.ui.login.bean.Login_CS;
import com.lin.cainiaolives.ui.login.bean.MobileLogin;
import com.lin.cainiaolives.ui.login.bean.MobileLogin_CS;
import com.lin.cainiaolives.ui.register.bean.MobileRegister;
import com.lin.cainiaolives.ui.register.bean.MobileRegister_CS;
import com.lin.cainiaolives.ui.register.bean.Register;
import com.lin.cainiaolives.ui.register.bean.Register_CS;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2017/2/14.
 */

public interface RetrofitApi {
//    @GET("/XRMall/rest/AppIndex.json")
//    Observable<AppIndex> getAppIndex(@Query("userId") int userId);

    //用户名登录
    @Headers("Content-Type: application/json")
    @POST("User")
    Observable<Login> login(@Body Login_CS login_cs);

    //手机号登录
    @Headers("Content-Type: application/json")
    @POST("User")
    Observable<MobileLogin> mobileLogin(@Body MobileLogin_CS mobileLogin_cs);

    //用户名注册
    @Headers("Content-Type: application/json")
    @POST("User")
    Observable<Register> register(@Body Register_CS register_cs);

    //手机号注册
    @Headers("Content-Type: application/json")
    @POST("User")
    Observable<MobileRegister> mobileRegister(@Body MobileRegister_CS mobileRegister_cs);
}
