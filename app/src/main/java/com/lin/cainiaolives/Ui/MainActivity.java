package com.lin.cainiaolives.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.lin.cainiaolives.R;
import com.lin.cainiaolives.base.BaseActivity;
import com.lin.cainiaolives.ui.main.FragmentHome;
import com.lin.cainiaolives.ui.main.FragmentSetting;
import com.lin.cainiaolives.ui.main.FragmentUser;
import com.lin.cainiaolives.ui.main.Tab;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(android.R.id.tabhost)
    FragmentTabHost mTabhost;
    @BindView(R.id.realtabcontent)
    FrameLayout mRealtabcontent;
    @BindView(android.R.id.tabcontent)
    FrameLayout mTabcontent;

    private List<Tab> mTabs = new ArrayList<>(3);

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
        mTabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        Tab one = new Tab(R.string.oneName, FragmentHome.class);
        Tab two = new Tab(R.string.twoName, FragmentUser.class);
        Tab three = new Tab(R.string.threeName, FragmentSetting.class);
        mTabs.add(one);
        mTabs.add(two);
        mTabs.add(three);
        for (Tab tab : mTabs) {
            mTabhost.addTab(mTabhost.newTabSpec(getString(tab.getTabName())).setIndicator(getTabItemView(tab)), tab.getFragment(), null);
        }
        mTabhost.getTabWidget().setDividerDrawable(null);
        mTabhost.setCurrentTab(0);
    }

    private View getTabItemView(Tab tab) {
        View mView = LayoutInflater.from(this).inflate(R.layout.item_main_tab, null);
        TextView tabName = (TextView) mView.findViewById(R.id.item_tab);
        tabName.setText(tab.getTabName());
        return mView;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
