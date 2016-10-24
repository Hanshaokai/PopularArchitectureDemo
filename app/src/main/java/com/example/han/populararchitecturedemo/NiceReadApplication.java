package com.example.han.populararchitecturedemo;

import android.app.Application;
import android.content.Context;

import com.example.han.populararchitecturedemo.utils.SPUtil;

/**
 * Created by ${han} on 2016/10/21.
 */

public class NiceReadApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initRealm();

        SPUtil.init(mContext, "niceread");
    }

    public static Context getmContext() {

        return mContext;
    }

    private void initRealm() {

        //RealmConfiguration realmConfiguration=new Rea
    }
}
