package com.example.han.populararchitecturedemo.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.example.han.populararchitecturedemo.presenter.BasePresenter;

/**
 * Created by ${han} on 2016/10/21.
 */

public abstract class BaseMvpActivity<V, P extends BasePresenter<V>> extends BaseActivity {

    protected P mPresenter;

    protected abstract P initPresenter();

    protected abstract void fetchData();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        mPresenter.attach((V) this);
        fetchData();
    }

    @Override
    protected void onDestroy() {
        mPresenter.detach();
        super.onDestroy();

    }
}
