package com.example.han.populararchitecturedemo.api;

import com.example.han.populararchitecturedemo.constant.Api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ${han} on 2016/10/21.
 */

public interface GirlDetailService {
    String BASE_URL = Api.URL_GET_GIRL;

    @GET("{id}")
    Observable<String> getGirlDetailData(@Path("id") String id);
}
