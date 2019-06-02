package com.example.example19;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";

    private boolean isCounting = true;

    /*仅在服务开启时调用1次，startService()*/
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "MyService onCreate");
        new Thread(() -> {
            while (isCounting) {
                count = count + step;
                Log.i(TAG, String.valueOf(count));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }).start();
    }

    /*每次调用startService()调用，用于传递参数*/
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "MyService onStartCommand");
        String name = intent.getStringExtra("name");
        Log.i(TAG, name);
        return super.onStartCommand(intent, flags, startId);
    }

    /*服务被stopService()或stopSelf()关闭时调用*/
    @Override
    public void onDestroy() {
        super.onDestroy();
        isCounting = false;
        Log.i(TAG, "MyService onDestroy");
    }

    /*继承实现了IBinder接口的实现类Binder，比直接实现接口简单*/
    class MyBinder extends Binder {
        public int getCount() {
            return count;
        }

        public void setStep(int newStep) {
            step = newStep;
        }
    }

    private int count;
    private int step = 1;
    private MyBinder myBinder = new MyBinder();

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "MyService onBind");
        //throw new UnsupportedOperationException("Not yet implemented");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "MyService onUnbind");
        return super.onUnbind(intent);
    }
}

