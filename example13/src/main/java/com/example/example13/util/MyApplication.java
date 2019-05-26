package com.example.example13.util;

import android.app.Application;

public class MyApplication extends Application {
    public static Application instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static Application getInstance() {
        return instance;
    }
}
