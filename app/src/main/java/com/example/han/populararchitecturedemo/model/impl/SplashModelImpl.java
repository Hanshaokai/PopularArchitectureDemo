package com.example.han.populararchitecturedemo.model.impl;


import com.example.han.populararchitecturedemo.api.SplashService;
import com.example.han.populararchitecturedemo.data.SplashData;
import com.example.han.populararchitecturedemo.model.ISplashModel;
import com.example.han.populararchitecturedemo.net.NetManager;

import rx.Observable;


public class SplashModelImpl implements ISplashModel {

    @Override
    public Observable<SplashData> getSplashPic() {
        SplashService service = NetManager.getInstance().create(SplashService.class);
        return service.getSplashPic();
    }
}
