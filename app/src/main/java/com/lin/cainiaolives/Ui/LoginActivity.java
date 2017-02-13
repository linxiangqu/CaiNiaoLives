package com.lin.cainiaolives.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lin.cainiaolives.R;
import com.lin.cainiaolives.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    @BindView(R.id.edt_login_username)
    EditText edtLoginUsername;
    @BindView(R.id.edt_login_password)
    EditText edtLoginPassword;
    @BindView(R.id.btn_login_denglv)
    Button btnLoginDenglv;
    @BindView(R.id.btn_mobile_login)
    Button btnMobileLogin;
    @BindView(R.id.btn_new_register)
    Button btnNewRegister;


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

    @OnClick({R.id.btn_login_denglv, R.id.btn_mobile_login, R.id.btn_new_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login_denglv:
                break;
            case R.id.btn_mobile_login:
                break;
            case R.id.btn_new_register:
                RegisterActivity.toRegisterActivity(this);
                break;
        }
    }
}
