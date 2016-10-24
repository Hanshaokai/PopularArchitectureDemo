package com.example.han.populararchitecturedemo.model.impl;



import com.example.han.populararchitecturedemo.api.GankItemService;
import com.example.han.populararchitecturedemo.data.GankItemData;
import com.example.han.populararchitecturedemo.data.HttpResult;
import com.example.han.populararchitecturedemo.model.IGankItemModel;
import com.example.han.populararchitecturedemo.net.NetManager;

import java.util.List;

import rx.Observable;

public class GankItemModelImpl implements IGankItemModel {

    @Override
    public Observable<HttpResult<List<GankItemData>>> getGankItemData(String suburl) {
        GankItemService service = NetManager.getInstance().create(GankItemService.class);
        return service.getGankItemData(suburl);
    }
}
