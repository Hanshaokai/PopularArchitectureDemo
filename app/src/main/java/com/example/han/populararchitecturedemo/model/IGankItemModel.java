package com.example.han.populararchitecturedemo.model;


import com.example.han.populararchitecturedemo.data.GankItemData;
import com.example.han.populararchitecturedemo.data.HttpResult;

import java.util.List;

import rx.Observable;


public interface IGankItemModel {
    Observable<HttpResult<List<GankItemData>>> getGankItemData(String suburl);
}
