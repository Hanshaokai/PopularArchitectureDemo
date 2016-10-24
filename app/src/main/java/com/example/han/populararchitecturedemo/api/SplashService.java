package com.example.han.populararchitecturedemo.api;

import com.example.han.populararchitecturedemo.constant.Api;
import com.example.han.populararchitecturedemo.data.SplashData;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Author: Othershe
 * Time:  2016/8/11 12:30
 */
public interface SplashService {
    String BASE_URL = Api.URL_GET_SPLASH_PIC;

    @GET("1080*1920")
    Observable<SplashData> getSplashPic();
}
