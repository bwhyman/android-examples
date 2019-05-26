package com.example.example13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.example13.dto.NewsDTO;
import com.example.example13.entity.News;
import com.example.example13.service.NewsService;
import com.example.example13.service.ServiceFactory;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button button;
    private TextView textView;
    private ImageView imageView;
    NewsService service = ServiceFactory.getNewsService();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        button.setOnClickListener(v -> {
            // 像网络请求这种线程阻塞的操作，禁止在主线程中执行
            // enqueue()为异步方法，将请求任务加入应用全局异步请求队列
            // 在异步子线程中获取响应对象，在主线程，回调结果。即onResponse()方法为主线程调用
            service.listNews().enqueue(new Callback<NewsDTO>() {
                @Override
                public void onResponse(Call<NewsDTO> call, Response<NewsDTO> response) {
                    if (response.body() == null) {
                        return;
                    }
                    // 基于converter-gson自动完成反序列化
                    NewsDTO newsDTO = response.body();
                    List<News> newsList = newsDTO.newsList;
                    textView.setText(newsList.get(0).title);
                }

                @Override
                public void onFailure(Call<NewsDTO> call, Throwable t) {

                }
            });
            // 基于图片资源地址，获取渲染图片
            service.getBitmap("resources/pics/Spain_Flag.jpg").enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    Log.i(TAG, "image");
                    // BitmapFactory类，提供将多种类型数据转为bitmap的静态方法
                    Bitmap bitmap = BitmapFactory.decodeStream( response.body().byteStream());
                    imageView.setImageBitmap(bitmap);

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });

        });

        findViewById(R.id.act_main_button_tosec).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecActivity.class);
            startActivity(intent);
        });
    }
}
