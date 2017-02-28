package com.lin.cainiaolives.ui.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lin.cainiaolives.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentHome extends Fragment {

    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    private View mView;
    private FragmentAdapter mFragmentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_home, container, false);
            ButterKnife.bind(this, mView);
            initView();
        }
        return mView;
    }

    private void initView() {
        mFragmentAdapter = new FragmentAdapter(getChildFragmentManager(), getContext());
        mFragmentAdapter.addFragment(new FragmentUser().newInstance("11111"), "11");
        mFragmentAdapter.addFragment(new FragmentUser().newInstance("22222"), "22");
        mFragmentAdapter.addFragment(new FragmentUser().newInstance("33333"), "33");
        mTablayout.setTabMode(TabLayout.MODE_FIXED);
        mViewpager.setAdapter(mFragmentAdapter);
        mTablayout.setupWithViewPager(mViewpager);
    }

}
