package com.lin.cainiaolives.Ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lin.cainiaolives.R;

public class LoginActivity extends BaseActivity {

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
}
