package com.lin.cainiaolives;

import android.app.Application;

import com.lin.cainiaolives.http.APIFactory;
import com.lin.cainiaolives.utilcode.CrashUtils;
import com.lin.cainiaolives.utilcode.LogUtils;
import com.lin.cainiaolives.utilcode.Utils;


/**
 * Created by hjzhang on 2016/7/27.
 */
public class MyApplication extends Application {
    private static MyApplication appContext;

    public static MyApplication getInstance() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        //初始化网络请求工具
        APIFactory.getInstance().init(this);
        Utils.init(appContext);
        CrashUtils.getInstance().init();
        LogUtils.getBuilder().setTag("MyTag").setLog2FileSwitch(true).create();
    }
}
