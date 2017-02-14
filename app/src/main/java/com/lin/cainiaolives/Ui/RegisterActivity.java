package com.lin.cainiaolives.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.lin.cainiaolives.R;
import com.lin.cainiaolives.base.BaseActivity;

public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
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
     * 启动RegisterActivity
     *
     * @param content
     */
    public static void toRegisterActivity(Context content) {
        content.startActivity(new Intent(content, RegisterActivity.class));
    }
}
