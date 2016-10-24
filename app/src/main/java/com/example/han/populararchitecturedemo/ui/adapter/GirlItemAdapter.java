package com.example.han.populararchitecturedemo.ui.adapter;

import android.content.Context;


import com.example.han.populararchitecturedemo.NiceReadApplication;
import com.example.han.populararchitecturedemo.R;
import com.example.han.populararchitecturedemo.data.GirlItemData;
import com.example.han.populararchitecturedemo.ui.adapter.baseadapter.BaseAdapter;
import com.example.han.populararchitecturedemo.ui.adapter.baseadapter.ViewHolder;
import com.example.han.populararchitecturedemo.ui.weiget.ScaleImageView;
import com.example.han.populararchitecturedemo.utils.ImageLoader;

import java.util.List;

/**
 * Author: Othershe
 * Time: 2016/8/18 21:59
 */
public class GirlItemAdapter extends BaseAdapter<GirlItemData> {

    public GirlItemAdapter(Context context, List<GirlItemData> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, GirlItemData girlItemData) {
        ScaleImageView imageView = holder.getView(R.id.girl_item_iv);
        imageView.setInitSize(girlItemData.getWidth(), girlItemData.getHeight());
        ImageLoader.load(NiceReadApplication.getmContext(),
                girlItemData.getUrl(), imageView);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_girl_layout;
    }
}
