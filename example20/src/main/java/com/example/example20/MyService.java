package com.example.example20;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    private MyReceiver myReceiver;

    @Override
    public void onCreate() {
        super.onCreate();
        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        IntentFilter intentFilter2 = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        IntentFilter intentFilter3 = new IntentFilter("My Action");
        registerReceiver(myReceiver, intentFilter);
        registerReceiver(myReceiver, intentFilter2);
        registerReceiver(myReceiver, intentFilter3);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (myReceiver != null) {
            unregisterReceiver(myReceiver);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}