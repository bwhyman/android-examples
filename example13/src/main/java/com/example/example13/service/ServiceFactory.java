package com.example.example13.service;

import com.example.example13.util.MyApplication;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {
    // 默认retrofit将请求的图片置于缓存，当向相同地址请求图片时，自动加载缓存的图片
    // 自动在data/data/应用包/cache下，创建缓存文件,10MB
    private static OkHttpClient client = new OkHttpClient.Builder()
            .cache(new Cache(MyApplication.getInstance().getCacheDir(), 10 * 1024 * 1024))
            .build();
    // 基于OKhttp对象，自定义属性，构造retrofit对象
    private static Retrofit retrofit = new Retrofit.Builder()
            // 本地测试不能使用localhost，使用本地IP
            // 根路径必须已，/，结束
            // .baseUrl("http://192.168.1.3:8080/api/")
            .baseUrl("http://www.whyman.site/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // retrofit自动创建接口的代理类
    public static NewsService getNewsService() {
        return retrofit.create(NewsService.class);
    }
}
