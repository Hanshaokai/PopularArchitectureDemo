package com.example.han.populararchitecturedemo.api;

import com.example.han.populararchitecturedemo.constant.Api;
import com.example.han.populararchitecturedemo.data.GankItemData;
import com.example.han.populararchitecturedemo.data.HttpResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ${han} on 2016/10/21.
 */

public interface GankItemService {
    String BASE_URL = Api.URL_GET_GANK;

    @GET("{suburl}")
    Observable<HttpResult<List<GankItemData>>> getGankItemData(@Path("suburl") String suburl);


}
