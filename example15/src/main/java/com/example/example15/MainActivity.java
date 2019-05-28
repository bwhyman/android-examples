package com.example.example15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * 内存储，其他应用无法访问的应用程序的独立空间，使用无需声明权限
 * 文件随应用删除而删除，空间有限，放应用必须文件
 * getFilesDir()/getCacheDir()
 * 在data/data/packagename/
 * 外存储：私有空间，公共空间
 * 私有空间，无需声明权限，随应用卸载删除，放普通文件，缓存文件
 * getExternalFilesDir()
 * getExternalCacheDir()
 * mnt/sdcard/android/data/packname/
 * 公共空间，需声明权限
 * Environment.getExternalStoragePublicDirectory()
 * mnt/sdcard/
 * android.permission.WRITE_EXTERNAL_STORAGE
 *
 * 可通过系统常量创建相应常见目录
 * 运行时权限，6.0
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.act_main_textview_environment);
        textView.setText(getEnvDir());

        findViewById(R.id.act_main_button).setOnClickListener(v -> {
            saveFile();
        });

    }
    // 获取各种目录
    private String getEnvDir() {
        String result = "";
        // 判断当前外置存储的状态
        String state = Environment.getExternalStorageState();
        /*Environment.MEDIA_MOUNTED.equals(state) ||
          Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)*/
        if (state == null) {
            Toast.makeText(this, "无存储设备", Toast.LENGTH_SHORT).show();
            return "";
        }
        result = result + "私有空间实际挂载到mnt/sdcard/android/data/packname/files" + "\n";
        // 私有空间,实际挂载：mnt/sdcard/android/data/packname/files
        result = result + "私有空间: " + getExternalFilesDir("/").toString() + "\n" ;
        // 私有空间带目录
        result = result + "指定私有空间下目录: " + getExternalFilesDir(Environment.DIRECTORY_PICTURES).toString() + "\n";
        // 私有缓存，存放临时文件，用户可通过android系统设置清除，不会自动清除
        result = result + "私有缓存目录: " + getExternalCacheDir() + "\n";
        // 公共空间，实际挂载;mnt/sdcard/
        result = result + "公共空间实际挂载到mnt/sdcard/" + "\n";
        result = result + "公共空间: " + Environment.getExternalStoragePublicDirectory("/") + "\n";
        // 指定的公共空间目录
        result = result + "指定公共空间下目录: " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        return result;
    }
    // 文件保存在指定目录
    private void saveFile() {
        String msg = "你好";
        // Path, Files,等需minsdk 26，为保证兼容性未使用
        // mnt/sdcard/android/data/packname/files/Picutures
        File file = new File(getExternalFilesDir("/"), "test.txt");
        // 需minsdk 19
        try(FileOutputStream os = new FileOutputStream(file)) {
            os.write(msg.getBytes());
        } catch (IOException e) {
        }
    }

}
