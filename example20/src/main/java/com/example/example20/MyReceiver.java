package com.example.example20;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    /*onReceive仅负责接收转发消息，不应进行消息处理等耗时操作应*/
    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.
        if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
            Toast.makeText(context, "Out Going Call", Toast.LENGTH_SHORT).show();
        }
        if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            Toast.makeText(context, "SCREEN ON", Toast.LENGTH_SHORT).show();
        }
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            Toast.makeText(context, "SCREEN OFF", Toast.LENGTH_SHORT).show();
        }
        if (intent.getAction().equals("My Action")) {
            Toast.makeText(context, "My Action", Toast.LENGTH_SHORT).show();
        }

    }
}