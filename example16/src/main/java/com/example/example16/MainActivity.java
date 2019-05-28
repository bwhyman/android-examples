package com.example.example16;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
    }

    String[] arrayFruit = new String[]{"苹果", "橘子", "草莓", "香蕉"};
    boolean[] checkedItems = new boolean[arrayFruit.length];
    int selectIndex = 0;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                // 用于警告等，合理基于设备返回键
                // 基于builder模式构建
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("标题");
                dialog.setMessage("内容");
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.show();
                break;
            case R.id.button2:
                AlertDialog.Builder dialog2 = new AlertDialog.Builder(this);
                dialog2.setTitle("删除");
                dialog2.setMessage("确定删除吗?");
                // 确认按钮回调
                dialog2.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                // 取消回调
                dialog2.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                // 中间回调
                dialog2.setNeutralButton("详细内容", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog2.show();
                break;
            case R.id.button3:
                // 单选按钮组
                AlertDialog.Builder dialog3 = new AlertDialog.Builder(this);
                dialog3.setTitle("水果");
                dialog3.setItems(arrayFruit, new DialogInterface.OnClickListener() {
                    // 传入的which为被选中的位置
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, arrayFruit[which], Toast.LENGTH_SHORT)
                                .show();
                    }
                });
                dialog3.show();
                break;
            case R.id.button4:
                // 单选，添加确认按钮
                AlertDialog.Builder dialog4 = new AlertDialog.Builder(this);
                dialog4.setTitle("水果");
                dialog4.setSingleChoiceItems(arrayFruit, selectIndex, new DialogInterface
                        .OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectIndex = which;
                    }
                });
                dialog4.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    // which不是被选中项目，按钮与选项无关
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, arrayFruit[selectIndex], Toast
                                .LENGTH_SHORT).show();
                    }
                });
                dialog4.show();
                break;
            case R.id.button5:
                // 自定义样式填充
                AlertDialog.Builder dialog5 = new AlertDialog.Builder(this);
                LayoutInflater inflater = LayoutInflater.from(this);
                View rootView = inflater.inflate(R.layout.dialog_login, null);
                dialog5.setTitle("登录");
                dialog5.setView(rootView);
                dialog5.show();
                break;
            case R.id.button6:
                // 多选，带确认按钮
                AlertDialog.Builder dialog6 = new AlertDialog.Builder(this);
                dialog6.setTitle("多选");
                dialog6.setIcon(R.mipmap.ic_launcher);
                dialog6.setMultiChoiceItems(arrayFruit, checkedItems, new DialogInterface
                        .OnMultiChoiceClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        String string;
                        if (isChecked) {
                            string = "被选中了";
                        } else {
                            string = "被取消了";
                        }
                        Toast.makeText(MainActivity.this, arrayFruit[which] + string, Toast
                                .LENGTH_SHORT).show();
                    }
                });
                dialog6.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuffer buffer = new StringBuffer();
                        for (int i = 0; i < arrayFruit.length; i++) {
                            if (checkedItems[i]) {
                                buffer.append(arrayFruit[i]);
                            }
                        }
                        Toast.makeText(MainActivity.this, "被选中的水果: " + buffer.toString(), Toast
                                .LENGTH_SHORT).show();
                    }
                });
                dialog6.show();
                break;
            case R.id.button7:
                // DatePickerDialog minsdk最低版本24，此处只有在系统版本大于24时执行有效
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    DatePickerDialog dialog7 = new DatePickerDialog(this);
                    final Calendar calendar = Calendar.getInstance();
                    dialog7.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            calendar.set(Calendar.YEAR, year);
                            calendar.set(Calendar.MONTH, month);
                            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                            String result = "日期: "
                                    + calendar.get(Calendar.YEAR) + "-"
                                    + calendar.get(Calendar.MONTH) + "-"
                                    + calendar.get(Calendar.DAY_OF_MONTH);
                            Toast.makeText(MainActivity.this, result , Toast.LENGTH_SHORT).show();
                        }
                    });
                    dialog7.show();
                }
                break;
        }
    }
}
