package com.example.han.populararchitecturedemo.presenter;


import com.example.han.populararchitecturedemo.model.IGirlItemModel;
import com.example.han.populararchitecturedemo.model.impl.GirlItemModelImpl;
import com.example.han.populararchitecturedemo.rx.RxManager;
import com.example.han.populararchitecturedemo.rx.RxSubscriber;
import com.example.han.populararchitecturedemo.ui.view.GirlItemView;
import com.example.han.populararchitecturedemo.utils.JsoupUtil;

/**
 * Author: Othershe
 * Time: 2016/8/12 14:29
 */
public class GirlItemPresenter extends BasePresenter<GirlItemView> {
    private IGirlItemModel mModel;

    public GirlItemPresenter() {
        mModel = new GirlItemModelImpl();
    }

    public void getGirlItemData(String cid, int page) {
        mSubscription = RxManager.getInstance().doSubscribe(mModel.getGirlItemData(cid, page), new RxSubscriber<String>(false) {
            @Override
            protected void _onNext(String s) {
                mView.onSuccess(JsoupUtil.parseGirls(s));
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}
