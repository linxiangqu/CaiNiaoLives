package com.lin.cainiaolives;

import android.app.Application;
import android.content.Context;

import com.lin.cainiaolives.http.APIFactory;


/**
 * Created by hjzhang on 2016/7/27.
 */
public class MyApplication extends Application {
    public static Context aContext;
    @Override
    public void onCreate() {
        super.onCreate();
        aContext = this;
        //初始化网络请求工具
        APIFactory.getInstance().init(this);
    }
}
