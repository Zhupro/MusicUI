package com.example.fero010.qqmusic;

import android.app.Application;
import android.content.Context;

/**
 * Created by FERO010 on 2016/4/26.
 */
public class MyApplication extends Application {
    public  static Context context;
    private static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        context = getApplicationContext();
    }
    public static Context getAppContext() {
        return context;
    }
}
