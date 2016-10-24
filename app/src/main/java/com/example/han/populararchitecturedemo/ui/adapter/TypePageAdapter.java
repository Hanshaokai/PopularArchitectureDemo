package com.example.han.populararchitecturedemo.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.han.populararchitecturedemo.ui.fragment.BaseMvpFragment;

import java.util.List;

/**
 * Created by ${han} on 2016/10/24.
 */

public class TypePageAdapter extends FragmentPagerAdapter {
    private List<BaseMvpFragment> fragments;
    private List<String> titles;

    public TypePageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setData(List<BaseMvpFragment> fragments, List<String> titles) {
        this.fragments = fragments;
        this.titles = titles;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
