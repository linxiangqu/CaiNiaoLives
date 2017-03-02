package com.lin.cainiaolives.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lin.cainiaolives.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentSetting extends Fragment {
    @BindView(R.id.btn_fx)
    Button mBtnFx;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_setting, container, false);
            ButterKnife.bind(this, mView);
        }
        return mView;
    }

    @OnClick(R.id.btn_fx)
    public void onClick() {

    }
}
