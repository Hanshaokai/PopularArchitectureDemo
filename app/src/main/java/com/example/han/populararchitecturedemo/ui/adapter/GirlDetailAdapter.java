package com.example.han.populararchitecturedemo.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.han.populararchitecturedemo.ui.fragment.BaseFragment;

import java.util.List;

/**
 * Created by ${han} on 2016/10/24.
 */

public class GirlDetailAdapter extends FragmentPagerAdapter {
    public GirlDetailAdapter(FragmentManager fm) {
        super(fm);
    }

    private List<BaseFragment> fragments;

    public void setData(List<BaseFragment> fragments) {
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}

