package com.lin.cainiaolives.http;


import com.lin.cainiaolives.bean.AppIndex;

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

    public void getAppIndexGet(Subscriber<AppIndex> subscriber, int param) {
        Observable<AppIndex> observable = retrofitApi.getAppIndex(param);
        toSubscribe(observable, subscriber);
    }
}
