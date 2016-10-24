package com.example.han.populararchitecturedemo.model.impl;


import com.example.han.populararchitecturedemo.api.GirlItemService;
import com.example.han.populararchitecturedemo.model.IGirlItemModel;
import com.example.han.populararchitecturedemo.net.NetManager;

import rx.Observable;

public class GirlItemModelImpl implements IGirlItemModel {
    @Override
    public Observable<String> getGirlItemData(String cid, int page) {
        GirlItemService service = NetManager.getInstance().create1(GirlItemService.class);
        return service.getGirlItemData(cid, page);
    }
}
