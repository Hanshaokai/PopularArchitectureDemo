package com.example.han.populararchitecturedemo.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.han.populararchitecturedemo.R;
import com.example.han.populararchitecturedemo.ui.adapter.TypePageAdapter;
import com.example.han.populararchitecturedemo.utils.ResourceUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${han} on 2016/10/21.
 */

public class TypeFragment extends BaseFragment {
    private static final String TYPE = "type";

    private String mType;
    private List<BaseMvpFragment> mFragments;
    private List<String> mTitles;

    private TypePageAdapter mTypeAdapter;

    @BindView(R.id.type_tablayout)
    TabLayout mTabLayout;

    @BindView(R.id.type_viewpager)
    ViewPager mViewPager;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_type_layout;
    }

    @Override
    protected void initView() {
        mTypeAdapter = new TypePageAdapter(getChildFragmentManager());
        mTypeAdapter.setData(mFragments, mTitles);
        mViewPager.setAdapter(mTypeAdapter);
        mViewPager.setOffscreenPageLimit(mTitles.size() - 1);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    protected void initData() {
        if (getArguments() == null) {
            return;
        }

        mFragments = new ArrayList<>();

        mType = getArguments().getString(TYPE);

        if (ResourceUtil.resTostr(mActivity, R.string.gank).equals(mType)) {
            mTitles = ResourceUtil.stringArrayToList(mActivity, R.array.gank);
            for (String title : mTitles) {
                mFragments.add(GankItemFragment.newInstance(title));
            }
        } else if (ResourceUtil.resTostr(mActivity, R.string.girl).equals(mType)) {
            mTitles = ResourceUtil.stringArrayToList(mActivity, R.array.girl);
            List<String> subtypes = ResourceUtil.stringArrayToList(mActivity, R.array.girl_cid);
            for (String subtype : subtypes) {
                mFragments.add(GirlItemFragment.newInstance(subtype));
            }
        }


    }

    public static TypeFragment newInstance(String type) {
        TypeFragment fragment = new TypeFragment();
        Bundle arguments = new Bundle();
        arguments.putString(TYPE, type);
        fragment.setArguments(arguments);
        return fragment;
    }
}
