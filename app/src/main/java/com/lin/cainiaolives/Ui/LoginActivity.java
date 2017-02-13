package com.lin.cainiaolives.Ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.lin.cainiaolives.ActivityCollector;
import com.lin.cainiaolives.R;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
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

    /**
     * 启动LoginActivity
     *
     * @param content
     */
    public static void toLoginActivity(Context content) {
        content.startActivity(new Intent(content, LoginActivity.class));
    }

    @OnClick(R.id.button)
    public void onClick() {
        ActivityCollector.finishAll();
    }
}
