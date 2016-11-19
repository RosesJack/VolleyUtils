package com.example.administrator.volleydemo2;

import android.app.Application;
import android.content.Context;

/**
 * auther：wzy
 * date：2016/11/20 00 :13
 * desc:
 */

public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();
    }

    public static Context getGlobalContext() {
        return mContext;
    }
}
