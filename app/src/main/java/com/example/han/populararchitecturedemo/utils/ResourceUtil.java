package com.example.han.populararchitecturedemo.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ${han} on 2016/10/24.
 */

public class ResourceUtil {
    /**
     * 解析Stirng 类型 的arrays.xml元素
     */
    public static List<String> stringArrayToList(Context context, int arrayId) {

        return Arrays.asList(context.getResources().getStringArray(arrayId));

    }

    public static String resTostr(Context context, int strId) {
        return context.getString(strId);
    }

    public static View inflate(Context context, int viewId, ViewGroup root) {

        return LayoutInflater.from(context).inflate(viewId, root, false);


    }

    public static int resToColor(Context context, int colorId) {

        return context.getResources().getColor(colorId);

    }
}
