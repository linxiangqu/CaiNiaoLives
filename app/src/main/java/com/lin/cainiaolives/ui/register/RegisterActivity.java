package com.lin.cainiaolives.ui.register;

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
import com.lin.cainiaolives.utilcode.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements IRegisterContract.IRegisterView {

    @BindView(R.id.btn_register_yzm)
    Button mBtnRegisterYzm;
    @BindView(R.id.register_TIL_username)
    TextInputLayout mRegisterTILUsername;
    @BindView(R.id.register_TIL_password)
    TextInputLayout mRegisterTILPassword;
    @BindView(R.id.register_TIL_repassword)
    TextInputLayout mRegisterTILRepassword;
    @BindView(R.id.btn_register_register)
    Button mBtnRegisterRegister;
    @BindView(R.id.btn_moblie_register)
    Button mBtnMoblieRegister;
    @BindView(R.id.edt_register)
    EditText mEdtRegister;
    @BindView(R.id.edt_register_password)
    EditText mEdtRegisterPassword;
    @BindView(R.id.edt_register_repeatpassword)
    EditText mEdtRegisterRepeatpassword;
    @BindView(R.id.btn_back_login)
    Button mBtnBackLogin;

    private boolean isMobileRegister = false;
    private IRegisterContract.IRegisterPresenter mIRegisterPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIRegisterPresenter = new RegisterPresenterImpl(this, retrofitUtil, this);
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

    @Override
    public void RegisterSuccess() {

    }

    @Override
    public void RegisterError(String msg) {
        ToastUtils.showShortToast(msg);
    }

    @Override
    public void SetButtonEnable(boolean enable) {
        mBtnRegisterYzm.setEnabled(enable);
    }

    @Override
    public void SetButtonText(String msg) {
        mBtnRegisterYzm.setText(msg);
    }

    @OnClick({R.id.btn_register_yzm, R.id.btn_register_register, R.id.btn_moblie_register, R.id.btn_back_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register_yzm:
                String phoneNumber = mEdtRegisterPassword.getText().toString().trim();
                mIRegisterPresenter.GetVerificationCode(phoneNumber);
                break;
            case R.id.btn_register_register:
                String password = mEdtRegisterPassword.getText().toString().trim();
                String repeatpassword = mEdtRegisterRepeatpassword.getText().toString().trim();
                if (isMobileRegister)
                    mIRegisterPresenter.MobileRegister(password, repeatpassword);
                else {
                    String usernmae = mEdtRegister.getText().toString().trim();
                    mIRegisterPresenter.NormalRegister(usernmae, password, repeatpassword);
                }
                break;
            case R.id.btn_moblie_register:
                if (isMobileRegister)
                    NormalRegisterViewInit();
                else
                    MobileRegisterViewInit();
                break;
            case R.id.btn_back_login:
                finish();
                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                break;
            default:
                break;
        }
    }

    private void MobileRegisterViewInit() {
        isMobileRegister = true;
        mEdtRegister.setText("");
        mEdtRegisterPassword.setText("");
        mEdtRegisterRepeatpassword.setText("");
        mRegisterTILUsername.setVisibility(View.GONE);
        mBtnRegisterYzm.setVisibility(View.VISIBLE);
        mRegisterTILPassword.setHint("请输入手机号");
        mRegisterTILRepassword.setHint("请输入验证码");
        mBtnMoblieRegister.setText("用户名注册");
        mEdtRegisterPassword.setInputType(InputType.TYPE_CLASS_PHONE);
        mEdtRegisterRepeatpassword.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    private void NormalRegisterViewInit() {
        isMobileRegister = false;
        mEdtRegister.setText("");
        mEdtRegisterPassword.setText("");
        mEdtRegisterRepeatpassword.setText("");
        mRegisterTILUsername.setVisibility(View.VISIBLE);
        mBtnRegisterYzm.setVisibility(View.GONE);
        mRegisterTILPassword.setHint(getString(R.string.pwd));
        mRegisterTILRepassword.setHint(getString(R.string.repassword));
        mBtnMoblieRegister.setText("手机号注册");
        mEdtRegisterPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        mEdtRegisterRepeatpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }
}
