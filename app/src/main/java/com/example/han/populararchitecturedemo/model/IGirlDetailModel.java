package com.example.han.populararchitecturedemo.model;

import rx.Observable;


public interface IGirlDetailModel {
    Observable<String> getGirlDetailData(String id);
}
