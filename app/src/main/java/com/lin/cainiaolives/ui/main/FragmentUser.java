package com.lin.cainiaolives.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lin.cainiaolives.R;
import com.lin.cainiaolives.ui.CKActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FragmentUser extends Fragment {
    @BindView(R.id.text)
    TextView mText;
    private View mView;
    private String name;

    public static FragmentUser newInstance(String name) {
        Bundle mBundle = new Bundle();
        mBundle.putString("id", name);
        FragmentUser fragmentUser = new FragmentUser();
        fragmentUser.setArguments(mBundle);
        return fragmentUser;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            name = getArguments().getString("id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_user, container, false);
            ButterKnife.bind(this, mView);
            mText.setText(name);
        }
        return mView;
    }

    @OnClick(R.id.text)
    public void onClick() {
        startActivity(new Intent(getActivity(), CKActivity.class));
    }
}
