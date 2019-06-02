package com.example.example18;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText editText;
    private EditText editText2;
    private Button button;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showNotification();

            }
        });
    }

    private void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default");
        // 通知必须包含：图标，标题，文本内容
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle(editText.getText().toString());
        builder.setContentText(editText2.getText().toString());
        // 设置提醒方法，震动、铃声等
        builder.setDefaults(Notification.DEFAULT_ALL);
        // 读取后是否自动在通知栏删除
        builder.setAutoCancel(true);
        // 当点击通知时的执行
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("title", editText.getText().toString());
        intent.putExtra("text", editText2.getText().toString());
        // 预处理intent，即延迟执行的intent
        PendingIntent pIntent = PendingIntent.getActivity(this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);  // 更新当前通知内容，没有通知则创建
        builder.setContentIntent(pIntent);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //8.0 以后需要加上channelId 才能正常显示
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "default";
            String channelName = "默认通知";
            manager.createNotificationChannel(new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH));
        }

        // 当发送ID相同的通知时，基于Pending设置，决定通知显示方法
        manager.notify(count, builder.build());
        count++;
    }
}
