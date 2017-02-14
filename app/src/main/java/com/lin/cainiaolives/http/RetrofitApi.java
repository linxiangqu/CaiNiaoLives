package com.lin.cainiaolives.http;


import com.lin.cainiaolives.bean.AppIndex;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/2/14.
 */

public interface RetrofitApi {
    @GET("/XRMall/rest/AppIndex.json")
    Observable<AppIndex> getAppIndex(@Query("userId") int userId);
}
