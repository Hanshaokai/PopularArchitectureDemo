package com.example.han.populararchitecturedemo.ui.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.han.populararchitecturedemo.R;
import com.example.han.populararchitecturedemo.data.GirlItemData;
import com.example.han.populararchitecturedemo.presenter.GirlDetailPresenter;
import com.example.han.populararchitecturedemo.ui.adapter.GirlDetailAdapter;
import com.example.han.populararchitecturedemo.ui.fragment.BaseFragment;
import com.example.han.populararchitecturedemo.ui.fragment.GirlDetailFragment;
import com.example.han.populararchitecturedemo.ui.view.GirlDetailView;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${han} on 2016/10/24.
 */

public class GirlDetailActivity extends BaseMvpActivity<GirlDetailView, GirlDetailPresenter> implements GirlDetailView {
    private GirlItemData mGirlItemData;

    @BindView(R.id.girl_detail_viewpager)
    ViewPager mViewPager;

    @BindView(R.id.girl_detail_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.girl_detail_loading)
    AVLoadingIndicatorView mLoading;

    @Override
    protected GirlDetailPresenter initPresenter() {
        return new GirlDetailPresenter();
    }

    @Override
    protected void fetchData() {
        mPresenter.getGirlDetailData(mGirlItemData.getId());
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_girl_detail;
    }

    @Override
    protected void initView() {
        initToolbar();
    }

    @Override
    protected void initData() {
        mGirlItemData = getIntent().getParcelableExtra("girl_item_data");
    }

    @Override
    public void onSuccess(List<String> data) {
        List<BaseFragment> fragments = new ArrayList<>();
        for (String url : data) {
            fragments.add(GirlDetailFragment.newInstance(url));
        }

        GirlDetailAdapter adapter = new GirlDetailAdapter(getSupportFragmentManager());
        adapter.setData(fragments);
        mViewPager.setOffscreenPageLimit(data.size());
        mViewPager.setAdapter(adapter);

        mLoading.hide();
    }

    @Override
    public void onError() {

    }

    private void initToolbar() {
        //setTitle方法要在setSupportActionBar(toolbar)之前调用，否则不起作用
        String title = mGirlItemData.getTitle();
        title = title.length() > 10 ? title.substring(0, 10) + "..." : title;
        mToolbar.setTitle(title);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

