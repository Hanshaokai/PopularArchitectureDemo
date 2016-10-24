package com.example.han.populararchitecturedemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ${han} on 2016/10/21.
 */

public class DateUtil {
    public static final String TYPE1 = "yyyy-MM-dd";

    public static String formatDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TYPE1, Locale.getDefault());
        Date date = new Date();
        return simpleDateFormat.format(date);
    }
}
