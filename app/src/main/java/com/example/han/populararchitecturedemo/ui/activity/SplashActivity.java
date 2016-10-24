package com.example.han.populararchitecturedemo.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;

import com.example.han.populararchitecturedemo.R;
import com.example.han.populararchitecturedemo.data.SplashData;
import com.example.han.populararchitecturedemo.presenter.SplashPresenter;
import com.example.han.populararchitecturedemo.ui.view.SplashView;
import com.example.han.populararchitecturedemo.utils.DateUtil;
import com.example.han.populararchitecturedemo.utils.ImageLoader;
import com.example.han.populararchitecturedemo.utils.NetUtil;
import com.example.han.populararchitecturedemo.utils.SPUtil;
import com.example.han.populararchitecturedemo.ui.fragment.SetFragment;

import butterknife.BindView;

/**
 * Created by ${han} on 2016/10/21.
 */

public class SplashActivity extends BaseMvpActivity<SplashView, SplashPresenter> implements SplashView {
    private String mTimeLine;

    @BindView(R.id.splash_iv)
    ImageView mSplashIv;


    @Override

    protected SplashPresenter initPresenter() {
        return new SplashPresenter();
    }

    @Override
    protected void fetchData() {
        if (!DateUtil.formatDate().equals(mTimeLine)) {
            mPresenter.getSplashPic();
        }
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        if (!(Boolean) SPUtil.get(SetFragment.SPLASH, false) || !NetUtil.isConnected(mContext)) {
            ImageLoader.load(mContext, R.drawable.original_splash, mSplashIv);
        } else {
            ImageLoader.load(mContext, (String) SPUtil.get("splash_url", ""), mSplashIv);
        }

        startDelay();
    }

    @Override
    protected void initData() {
        mTimeLine = (String) SPUtil.get("splash_time", "");
    }

    @Override
    public void onSuccess(SplashData data) {
        SPUtil.save("splash_time", DateUtil.formatDate());
        SPUtil.save("splash_url", data.getUrl());
    }

    @Override
    public void onError() {

    }

    private void startDelay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 6000);
    }
}
