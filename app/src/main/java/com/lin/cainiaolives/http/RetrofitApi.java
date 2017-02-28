package com.lin.cainiaolives.http;


import com.lin.cainiaolives.ui.login.bean.Login;
import com.lin.cainiaolives.ui.login.bean.Login_CS;
import com.lin.cainiaolives.ui.login.bean.MobileLogin;
import com.lin.cainiaolives.ui.login.bean.MobileLogin_CS;

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

    @Headers("Content-Type: application/json")
    @POST("User")
    Observable<Login> login(@Body Login_CS login_cs);

    @Headers("Content-Type: application/json")
    @POST("User")
    Observable<MobileLogin> mobileLogin(@Body MobileLogin_CS mobileLogin_cs);
}
