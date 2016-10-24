package com.example.han.populararchitecturedemo.presenter;


import com.example.han.populararchitecturedemo.model.IGirlDetailModel;
import com.example.han.populararchitecturedemo.model.impl.GirlDetailModelImpl;
import com.example.han.populararchitecturedemo.rx.RxManager;
import com.example.han.populararchitecturedemo.rx.RxSubscriber;
import com.example.han.populararchitecturedemo.ui.view.GirlDetailView;
import com.example.han.populararchitecturedemo.utils.JsoupUtil;

/**
 * Author: Othershe
 * Time: 2016/8/12 14:29
 */
public class GirlDetailPresenter extends BasePresenter<GirlDetailView> {
    private IGirlDetailModel mModel;

    public GirlDetailPresenter() {
        mModel = new GirlDetailModelImpl();
    }

    public void getGirlDetailData(String id) {
        mSubscription = RxManager.getInstance().doSubscribe(mModel.getGirlDetailData(id), new RxSubscriber<String>(false) {
            @Override
            protected void _onNext(String s) {
                mView.onSuccess(JsoupUtil.parseGirlDetail(s));
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}
