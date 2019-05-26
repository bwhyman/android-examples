package com.example.example13.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.example13.dto.NewsDTO;
import com.example.example13.entity.News;
import com.example.example13.service.NewsService;
import com.example.example13.service.ServiceFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecViewModel extends AndroidViewModel {
    public MutableLiveData<List<News>> newsList = new MutableLiveData<>();
    private NewsService newsService = ServiceFactory.getNewsService();
    public SecViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadNews() {
        newsService.listNews().enqueue(new Callback<NewsDTO>() {
            @Override
            public void onResponse(Call<NewsDTO> call, Response<NewsDTO> response) {
                if (response.body() == null) {
                    return;
                }
                List<News> news = response.body().newsList;
                newsList.setValue(news);
            }

            @Override
            public void onFailure(Call<NewsDTO> call, Throwable t) {

            }
        });
    }
}
