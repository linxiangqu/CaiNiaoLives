package com.lin.cainiaolives.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lin.cainiaolives.R;
import com.lin.cainiaolives.base.BaseActivity;
import com.lin.cainiaolives.ui.register.RegisterActivity;
import com.lin.cainiaolives.utilcode.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginContract.ILoginView {

    private static final String TAG = LoginActivity.class.getSimpleName();
    @BindView(R.id.edt_login_username)
    EditText mEdtLoginUsername;
    @BindView(R.id.edt_login_password)
    EditText mEdtLoginPassword;
    @BindView(R.id.btn_login_mobilecode)
    Button mBtnLoginMobilecode;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.btn_mobile_login)
    Button mBtnMobileLogin;
    @BindView(R.id.btn_new_register)
    Button mBtnNewRegister;
    @BindView(R.id.login_TIL_username)
    TextInputLayout mLoginTILUsername;
    @BindView(R.id.login_TIL_password)
    TextInputLayout mLoginTILPassword;

    private ILoginContract.ILoginPresenter mILoginPresenter;
    private boolean isMobileLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mILoginPresenter = new LoginPresenterImpl(retrofitUtil, this, this);
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

    @Override
    public void LoginSuccess() {
        RegisterActivity.toRegisterActivity(this);
    }

    @Override
    public void LoginError(String msg) {
        ToastUtils.showShortToast(msg);
    }

    @Override
    public void SetButtonEnable(boolean enable) {
        mBtnLoginMobilecode.setEnabled(enable);
    }

    @Override
    public void SetButtonText(String msg) {
        mBtnLoginMobilecode.setText(msg);
    }

    @OnClick({R.id.btn_login_mobilecode, R.id.btn_login, R.id.btn_mobile_login, R.id.btn_new_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login_mobilecode:
                String phoneNumber = mEdtLoginUsername.getText().toString().trim();
                mILoginPresenter.GetVerificationCode(phoneNumber);
                break;
            case R.id.btn_login:
                String usename = mEdtLoginUsername.getText().toString().trim();
                String password = mEdtLoginPassword.getText().toString().trim();
                if (isMobileLogin)
                    mILoginPresenter.Login_Mobile(usename, password);
                else
                    mILoginPresenter.Login(usename, password);
                break;
            case R.id.btn_mobile_login:
                if (isMobileLogin)
                    NormalLoginViewInit();
                else
                    MobileLoginViewInit();
                break;
            case R.id.btn_new_register:
                RegisterActivity.toRegisterActivity(this);
                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                break;
            default:
                break;
        }
    }

    private void NormalLoginViewInit() {
        isMobileLogin = false;
        mEdtLoginUsername.setText("");
        mEdtLoginPassword.setText("");
        mEdtLoginUsername.setInputType(InputType.TYPE_CLASS_TEXT);
        mLoginTILUsername.setHint(getString(R.string.register_username));
        mLoginTILPassword.setHint(getString(R.string.pwd));
        mBtnLoginMobilecode.setVisibility(View.GONE);
        mBtnMobileLogin.setText("手机号登录");
    }

    private void MobileLoginViewInit() {
        isMobileLogin = true;
        mEdtLoginUsername.setText("");
        mEdtLoginPassword.setText("");
        mEdtLoginUsername.setInputType(InputType.TYPE_CLASS_NUMBER);
        mLoginTILUsername.setHint("请输入手机号");
        mLoginTILPassword.setHint("请输入验证码");
        mBtnLoginMobilecode.setVisibility(View.VISIBLE);
        mBtnMobileLogin.setText("用户名登录");
    }
}
