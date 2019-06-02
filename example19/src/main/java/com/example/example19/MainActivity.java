package com.example.example19;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startService;
    private Button stopService;
    private Button bindService;
    private Button unBindService;
    private Button getCount;
    private TextView textView;
    private EditText editStep;
    private Button setStep;
    private ServiceConnection conn;
    private MyService.MyBinder myBinder;
    private boolean mBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService = findViewById(R.id.button_startservice);
        stopService = findViewById(R.id.button_stopservice);
        bindService = findViewById(R.id.button_bindservice);
        unBindService = findViewById(R.id.button_unbindservice);
        setStep = findViewById(R.id.button_set);
        setStep.setOnClickListener(this);
        getCount = findViewById(R.id.button_getcount);
        textView = findViewById(R.id.textView1);
        editStep = findViewById(R.id.editText);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        bindService.setOnClickListener(this);
        unBindService.setOnClickListener(this);
        getCount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_startservice:
                /*
                 * startService() 仅启动1个服务对象，关闭应用服务在后台运行
                 * 但可以多次调用传递参数，服务回调onStartCommand接收参数
                 */
                Intent intent = new Intent(this, MyService.class);
                intent.putExtra("name", "BO");
                startService(intent);
                break;
            case R.id.button_stopservice:
                /*
                 * stopService 停止服务
                 */
                Intent intent2 = new Intent(this, MyService.class);
                stopService(intent2);
                break;
            case R.id.button_bindservice:
                /*
                 * bindService 绑定或创建1个服务对象，服务回调onBind接收参数 可多次调用传递参数，服务回调onRebind接收参数
                 * 必须在使用的组件中销毁 当服务不是bindService创建时仅解除绑定，不会销毁服务对象
                 */
                conn = new MyServiceConnection();
                Intent intent3 = new Intent(this, MyService.class);
                bindService(intent3, conn, BIND_AUTO_CREATE);
                break;
            case R.id.button_unbindservice:
                // 判断，如果已经解除绑定，再次unbind会报错
                if (mBound) {
                    unbindService(conn);
                    conn = null;
                    myBinder = null;
                    mBound = false;
                }

                break;
            case R.id.button_getcount:
                if (conn != null && myBinder != null) {
                    textView.setText(String.valueOf(myBinder.getCount()));
                }
                break;
            case R.id.button_set:
                if (conn != null && myBinder != null) {
                    myBinder.setStep(Integer.valueOf(editStep.getText().toString()));
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        // 在组件生命周期中自动解除绑定
        if (conn != null && myBinder != null) {
            unbindService(conn);
            conn = null;
            myBinder = null;
        }
        super.onDestroy();
    }

    // 绑定服务的连接对象
    class MyServiceConnection implements ServiceConnection {
        // 当连接服务后回调，通过Ibinder对象与服务互交
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyService.MyBinder) service;
            mBound = true;
        }

        // 绑定服务的连接对象
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    }
}
