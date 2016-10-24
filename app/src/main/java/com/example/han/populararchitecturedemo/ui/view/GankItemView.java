package com.example.han.populararchitecturedemo.ui.view;


import com.example.han.populararchitecturedemo.data.GankItemData;

import java.util.List;

/**
 * Author: Othershe
 * Time: 2016/8/12 14:31
 */
public interface GankItemView extends IBaseView {
    void onSuccess(List<GankItemData> data);
}
