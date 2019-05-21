package com.example.example12.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.example12.entity.News;

import java.util.ArrayList;
import java.util.List;

public class SecViewModel extends AndroidViewModel {
    private static final String TAG = "SecViewModel";
    // 模拟每次获取的新数据，不是加上旧的全部数据
    public MutableLiveData<List<News>> newsLoad = new MutableLiveData<>();

    public SecViewModel(@NonNull Application application) {
        super(application);
        // 加载的同时发出异步获取更新数据请求
        initNews();
    }

    /**
     *  模拟异步请求并获取最新的数据
     */
    private void initNews() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                News n1 = new News(1, "阿根廷VS波黑", "小组赛F组 阿根廷VS波黑");
                List<News> news = new ArrayList<>();
                news.add(n1);
                // 将数据异步更新绑定
                newsLoad.postValue(news);
            } catch (InterruptedException e) {
            }
        }).start();
    }

    public void loadNews() {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                News n1 = new News(1, "荷兰VS西班牙", "小组赛F组 荷兰VS西班牙");
                List<News> news = new ArrayList<>();
                news.add(n1);
                newsLoad.postValue(news);

            } catch (InterruptedException e) {

            }
        }).start();
    }
}
