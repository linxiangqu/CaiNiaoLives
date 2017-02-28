package com.lin.cainiaolives.ui.main;

/**
 * Created by Administrator on 2017/2/28.
 */

public class Tab {
    private int tabName;
    private Class fragment;

    public Tab(int tabName, Class fragment) {
        this.tabName = tabName;
        this.fragment = fragment;
    }

    public int getTabName() {
        return tabName;
    }

    public void setTabName(int tabName) {
        this.tabName = tabName;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
