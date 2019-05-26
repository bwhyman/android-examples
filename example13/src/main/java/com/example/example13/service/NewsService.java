package com.example.example13.service;

import com.example.example13.dto.NewsDTO;
import com.example.example13.entity.News;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * 后端将数据封装在Map转为json
 * 与基于弱类型JS的前端处理不同，由于无法确定Map中值的类型而无法反序列化数据
 * 因此，为返回的响应创建对应转换的DTO类型，响应数据封装在DTO对象属性中
 * 请求路径不能使用，/，开始，否则baseurl设置会无效，将直接向服务器根路径相对请求
 * 请求注解与springMVC相似
 */
public interface NewsService {
    @GET("news/{id}")
    Call<NewsDTO> getNews(@Path("id") int id);

    @GET("news")
    Call<NewsDTO> listNews();

    /**
     * 全局的图片下载，可声明在一个独立的接口，此处简化
     * 传入图片地址，响应返回图片封装在ResponseBody
     * 结合构造retrofit时的缓存策略，自动重用缓存图片
     * 可结合自定义bindingadapter使用，更简洁，耦合性更低
     * @param url
     * @return
     */
    @GET
    Call<ResponseBody> getBitmap(@Url String url);

    /**
     * 即使没有返回值，也必须封装一个空类型Void
     * @param n
     * @return
     */
    @POST("news")
    Call<ResponseBody> post(@Body News n);
}
