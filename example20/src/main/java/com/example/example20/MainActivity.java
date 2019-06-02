package com.example.example20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/*1个receiver可设置多个消息过滤器
 * 监听系统广播时，注意声明相应权限
 * 2种注册receiver的方式，动态和常驻
 *
 * 1.常驻型，在Manifest中声明注册，应用是否启动均执行监听
 * 在系统运行服务中也无法查看
 * 2.在code中注册，结合service使用，可动态注册、解除监听
 */
public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MyService.class);
                MainActivity.this.startService(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MyService.class);
                MainActivity.this.stopService(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 必须注册自定义的过滤器
                Intent intent = new Intent();
                intent.setAction("My Action");
                MainActivity.this.sendBroadcast(intent);
            }
        });
    }
}
