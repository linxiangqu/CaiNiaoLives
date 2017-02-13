package com.lin.cainiaolives.Ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/11.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();
    public List<Activity> activitys = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: " + getClass().getSimpleName());
        addActivity(this);
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

    public void addActivity(Activity activity) {
        activitys.add(activity);
    }

    public void removeActivity(Activity activity) {
        activitys.remove(activity);
    }

    public void finishAll() {
        for (Activity activity : activitys) {
            if (!activity.isFinishing())
                activity.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
    }
}
