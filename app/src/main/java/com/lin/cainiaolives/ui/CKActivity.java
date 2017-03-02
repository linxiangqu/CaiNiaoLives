package com.lin.cainiaolives.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.lin.cainiaolives.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CKActivity extends Activity {


    @BindView(R.id.btn_finish)
    Button mBtnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ck);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.btn_finish)
    public void onClick() {
        Toast.makeText(this,"111",Toast.LENGTH_SHORT).show();
    }
}
