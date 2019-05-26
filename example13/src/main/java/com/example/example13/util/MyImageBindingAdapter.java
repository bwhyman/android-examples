package com.example.example13.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.example13.R;
import com.example.example13.service.ServiceFactory;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyImageBindingAdapter {
    private static final String TAG = "MyImageBindingAdapter";

    /**
     * 直接声明imageUrl属性，而非app:imageUrl
     * @param view 第一个参数，是自动传入的，绑定的imageview控件对象
     * @param url 第二个参数，为动态绑定的属性值，即图片网络地址
     */
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        // 默认渲染图片
        if (url == null) {
            view.setImageResource(R.mipmap.ic_launcher);
            return;
        }
        ServiceFactory.getNewsService().getBitmap(url).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() == null) {
                    return;
                }
                view.setImageBitmap(BitmapFactory.decodeStream(response.body().byteStream()));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });

    }
}
