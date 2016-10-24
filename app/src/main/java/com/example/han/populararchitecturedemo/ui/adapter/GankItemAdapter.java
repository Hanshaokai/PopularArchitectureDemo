package com.example.han.populararchitecturedemo.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.example.han.populararchitecturedemo.NiceReadApplication;
import com.example.han.populararchitecturedemo.R;
import com.example.han.populararchitecturedemo.data.GankItemData;
import com.example.han.populararchitecturedemo.ui.adapter.baseadapter.BaseAdapter;
import com.example.han.populararchitecturedemo.ui.adapter.baseadapter.ViewHolder;
import com.example.han.populararchitecturedemo.utils.ImageLoader;

import java.util.List;

/**
 * Created by ${han} on 2016/10/24.
 */

public class GankItemAdapter extends BaseAdapter<GankItemData> {


    public GankItemAdapter(Context context, List<GankItemData> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, GankItemData gankItemData) {
        holder.setText(R.id.gank_item_desc, gankItemData.getDesc());

        String who = TextUtils.isEmpty(gankItemData.getWho()) ? "null" : gankItemData.getWho();
        holder.setText(R.id.gank_item_who, who);

        holder.setText(R.id.gank_item_publishedat, gankItemData.getPublishedAt().substring(0, 10));

        ImageView image = holder.getView(R.id.gank_item_icon);

        String[] images = gankItemData.getImages();
        if (images != null && images.length > 0) {
            ImageLoader.load(NiceReadApplication.getmContext(),
                    images[0] + "?imageView2/0/w/100", image, R.drawable.web);
        } else {
            String url = gankItemData.getUrl();
            int iconId;
            if (url.contains("github")) {
                iconId = R.drawable.github;
            } else if (url.contains("jianshu")) {
                iconId = R.drawable.jianshu;
            } else if (url.contains("csdn")) {
                iconId = R.drawable.csdn;
            } else if (url.contains("miaopai")) {
                iconId = R.drawable.miaopai;
            } else if (url.contains("acfun")) {
                iconId = R.drawable.acfun;
            } else if (url.contains("bilibili")) {
                iconId = R.drawable.bilibili;
            } else if (url.contains("youku")) {
                iconId = R.drawable.youku;
            } else if (url.contains("weibo")) {
                iconId = R.drawable.weibo;
            } else if (url.contains("weixin")) {
                iconId = R.drawable.weixin;
            } else {
                iconId = R.drawable.web;
            }
            ImageLoader.load(NiceReadApplication.getmContext(), iconId, image);
        }
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_gank_layout;
    }

}
