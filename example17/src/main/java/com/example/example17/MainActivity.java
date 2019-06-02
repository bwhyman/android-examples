package com.example.example17;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final int CAPTURE_IMAGE_REQUEST = 100;
    private static final int CAPTURE_IMAGE_PERMISSION = 99;
    private ImageView cameraImageView;
    private TextView textView;
    private String cameraFileName;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.act_main_textview);
        cameraImageView = findViewById(R.id.act_main_imageview);
        // 可以置于外存储私有空间。此处置于公共空间DCIM下
        cameraFileName = Environment.getExternalStorageDirectory() + "/DCIM/Camera/image.jpg";

    }

    public void startCapture(View view) {
        // 动态判断当前权限，用户授权后
        /*if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // 如果用户曾经拒绝过
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            }

        } else {
            capture();
        }*/
        // 动态申请权限，回调onRequestPermissionsResult()方法
        // 没有授权，则弹出请求窗口，有授权则直接回调方法
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                CAPTURE_IMAGE_PERMISSION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            // 判断哪个授权
            case CAPTURE_IMAGE_PERMISSION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 用户授权后回调执行
                    capture();
                }
                return;
        }

    }

    private void capture() {
        // 需配置file path，将文件地址转为uri地址封装在intent
        // 强制相机存储到指定的URI位置，否则图片将储存到默认位置
        // android7开始，禁止部分请求直接使用file类型，必须使用uri地址
        uri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID, new File(cameraFileName));
        textView.setText(uri.toString());
        // 添加外部启动相机的action
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        // 基于指定请求代码请求
        startActivityForResult(intent, CAPTURE_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CAPTURE_IMAGE_REQUEST:
                if (resultCode == RESULT_OK) {
                    /**
                     * 如果使用之前putExtra方法加入启动activity，则获得的data为null；
                     * 系统默认调用相机返回的data才不为空
                     * 使用此方法获得的位图为原始位图而不是缩略图
                     */
                    /**
                     * 防止出现OOM错误，设定将原始位图缩减4倍
                     * 次步骤很重要，我的相机默认图片大小为2.4M
                     */
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 4;
                    Bitmap newBitmap = BitmapFactory.decodeFile(cameraFileName, options);
                    cameraImageView.setImageBitmap(newBitmap);

                    // 通知相册刷新
                    Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri);
                    sendBroadcast(mediaScanIntent);
                }
                break;
        }
    }

    public void toSecActivity(View view) {
        Intent intent = new Intent(this, SecActivity.class);
        startActivity(intent);
    }
}
