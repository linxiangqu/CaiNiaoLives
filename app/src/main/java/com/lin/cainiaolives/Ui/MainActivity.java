package com.lin.cainiaolives.Ui;

import android.os.Bundle;
import android.widget.TextView;

import com.lin.cainiaolives.R;

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
        LoginActivity.toLoginActivity(MainActivity.this);
    }
}
