package com.example.han.populararchitecturedemo.presenter;

import com.example.han.populararchitecturedemo.data.SplashData;
import com.example.han.populararchitecturedemo.model.ISplashModel;
import com.example.han.populararchitecturedemo.model.impl.SplashModelImpl;
import com.example.han.populararchitecturedemo.rx.RxManager;
import com.example.han.populararchitecturedemo.rx.RxSubscriber;
import com.example.han.populararchitecturedemo.ui.view.SplashView;

/**
 * Created by ${han} on 2016/10/21.
 */

public class SplashPresenter extends BasePresenter<SplashView> {
    private ISplashModel mModel;

    public SplashPresenter() {
        mModel = new SplashModelImpl();
    }

    public void getSplashPic() {
        mSubscription = RxManager.getInstance().doSubscribe(mModel.getSplashPic(), new RxSubscriber<SplashData>(false) {


            @Override
            protected void _onNext(SplashData splashData) {
                mView.onSuccess(splashData);
            }

            @Override
            protected void _onError() {

            }
        });
    }


}
