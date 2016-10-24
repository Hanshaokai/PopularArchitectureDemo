package com.example.han.populararchitecturedemo.model.impl;

import com.example.han.populararchitecturedemo.api.GirlDetailService;
import com.example.han.populararchitecturedemo.model.IGirlDetailModel;
import com.example.han.populararchitecturedemo.net.NetManager;

import rx.Observable;

/**
 *
 */
public class GirlDetailModelImpl implements IGirlDetailModel {

    @Override
    public Observable<String> getGirlDetailData(String id) {
        GirlDetailService service = NetManager.getInstance().create1(GirlDetailService.class);
        return service.getGirlDetailData(id);
    }
}
