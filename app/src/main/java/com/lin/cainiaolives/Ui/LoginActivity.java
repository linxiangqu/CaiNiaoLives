package com.lin.cainiaolives.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lin.cainiaolives.R;
import com.lin.cainiaolives.base.BaseActivity;
import com.lin.cainiaolives.ui.login.presenter.ILoginPresenter;
import com.lin.cainiaolives.ui.login.presenter.ILoginPresenterImpl;
import com.lin.cainiaolives.ui.login.view.ILoginView;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView {

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
    private ILoginPresenter iLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iLoginPresenter = new ILoginPresenterImpl(this, retrofitUtil, this);
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
                iLoginPresenter.login(edtLoginUsername.getText().toString().trim(), edtLoginPassword.getText().toString().trim());
                break;
            case R.id.btn_mobile_login:
                break;
            case R.id.btn_new_register:
                RegisterActivity.toRegisterActivity(this);
                break;
        }
    }

    @Override
    public void loginSuccess() {
        RegisterActivity.toRegisterActivity(this);
    }
}
