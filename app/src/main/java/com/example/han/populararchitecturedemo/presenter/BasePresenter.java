package com.example.han.populararchitecturedemo.presenter;

import rx.Subscription;

/**
 * Created by ${han} on 2016/10/21.
 */

public class BasePresenter<V> {
    public V mView;
    protected Subscription mSubscription;

    public void attach(V view) {
        mView = view;
    }

    public void detach() {
        mView = null;
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
    }
}
