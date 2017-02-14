package com.lin.cainiaolives.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lin.cainiaolives.ActivityCollector;
import com.lin.cainiaolives.http.APIFactory;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;


public abstract class BaseActivity extends AutoLayoutActivity {
    public APIFactory retrofitUtil = (APIFactory) APIFactory.getInstance();
    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: " + getClass().getSimpleName());
        ActivityCollector.addActivity(this);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initData();
        initView();
        initListener();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
