package com.example.han.populararchitecturedemo.presenter;

import com.example.han.populararchitecturedemo.data.GankItemData;
import com.example.han.populararchitecturedemo.model.IGankItemModel;
import com.example.han.populararchitecturedemo.model.impl.GankItemModelImpl;
import com.example.han.populararchitecturedemo.rx.RxManager;
import com.example.han.populararchitecturedemo.rx.RxSubscriber;
import com.example.han.populararchitecturedemo.ui.view.GankItemView;

import java.util.List;

/**
 * Created by ${han} on 2016/10/24.
 */

public class GankItemPresenter extends BasePresenter<GankItemView> {
    private IGankItemModel mModel;

    public GankItemPresenter() {
        mModel = new GankItemModelImpl();
    }

    public void getGankItemData(String suburl) {
        mSubscription = RxManager.getInstance().doSubscribe1(mModel.getGankItemData(suburl), new RxSubscriber<List<GankItemData>>(true) {
            @Override
            protected void _onNext(List<GankItemData> gankItemData) {
                mView.onSuccess(gankItemData);
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}