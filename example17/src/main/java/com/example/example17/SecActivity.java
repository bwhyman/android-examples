package com.example.example17;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class SecActivity extends AppCompatActivity {
    public static final int RESULT_LOAD_IMAGE = 101;

    private ImageView selectImageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        selectImageView = findViewById(R.id.act_sec_imageview);
        textView = findViewById(R.id.act_sec_textview);
    }

    public void selected(View view) {
        /**
         * Images.Media.EXTERNAL_CONTENT_URI 字符串常量表示外部存储中的图片
         */
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, RESULT_LOAD_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_LOAD_IMAGE:
                if (resultCode == RESULT_OK) {
                    ContentResolver resolver = getContentResolver();
                    Uri selectedImageUri = data.getData();
                    // 显示uri地址
                    textView.setText(selectedImageUri.toString());
                    try {
                        /**
                         * 通过uri地址获取图片，缩4倍显示
                         */
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(resolver, selectedImageUri);
                        int dsWidth = bitmap.getWidth() / 4;
                        int dstHeight = bitmap.getHeight() / 4;
                        bitmap = Bitmap.createScaledBitmap(bitmap, dsWidth, dstHeight, true);

                        selectImageView.setImageBitmap(bitmap);
                    } catch (IOException e) {

                    }
                }
                break;
        }
    }
}
