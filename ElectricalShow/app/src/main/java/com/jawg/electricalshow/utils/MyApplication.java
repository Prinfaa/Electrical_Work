package com.jawg.electricalshow.utils;

import android.app.Application;
import android.content.Context;



public class MyApplication extends Application {


    private static Context sContext;

    public static Context getContext() {

        if(sContext==null){

            sContext=new MyApplication();

        }
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }




    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }
}
