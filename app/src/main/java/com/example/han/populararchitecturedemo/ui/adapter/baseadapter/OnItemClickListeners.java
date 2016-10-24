package com.example.han.populararchitecturedemo.ui.adapter.baseadapter;

import android.support.v7.widget.RecyclerView;

/**
 * Created by ${han} on 2016/10/24.
 */

public interface OnItemClickListeners<T> {
    void onItemClick(ViewHolder viewHolder, T data, int position);
}
