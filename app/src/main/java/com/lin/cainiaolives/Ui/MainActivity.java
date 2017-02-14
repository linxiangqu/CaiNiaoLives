package com.lin.cainiaolives.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.lin.cainiaolives.R;
import com.lin.cainiaolives.base.BaseActivity;
import com.lin.cainiaolives.bean.AppIndex;
import com.lin.cainiaolives.http.ProgressSubscriber;
import com.lin.cainiaolives.http.SubscriberOnNextListener;
import com.lin.cainiaolives.utilcode.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @OnClick(R.id.text)
    public void onClick() {
//        LoginActivity.toLoginActivity(MainActivity.this);
        retrofitUtil.setUseCache(true);
        retrofitUtil.setMaxCacheTime(1024);
        retrofitUtil.getAppIndexGet(new ProgressSubscriber<AppIndex>(new SubscriberOnNextListener<AppIndex>() {
            @Override
            public void onNext(AppIndex appIndex) {
                text.setText(appIndex.getMsg());
            }

            @Override
            public void onError(int code, String message) {
                ToastUtils.showShortToast(code + "___" + message);
            }
        }, MainActivity.this, true), 34);
    }
}
