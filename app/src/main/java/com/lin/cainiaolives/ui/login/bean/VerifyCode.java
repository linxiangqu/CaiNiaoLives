package com.lin.cainiaolives.ui.login.bean;

/**
 * Created by Administrator on 2017/3/2.
 */

public class VerifyCode {
    /**
     * status : 0
     * msg : 验证码已发送
     */

    private int status;
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
