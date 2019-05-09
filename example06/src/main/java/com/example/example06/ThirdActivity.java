package com.example.example06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.example06.adapter.SecAdapter;
import com.example.example06.adapter.ThirdAdapter;
import com.example.example06.entity.News;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    private static final String TAG = "ThirdActivity";
    private RecyclerView recyclerView;
    private ThirdAdapter adapter;
    private SwipeRefreshLayout swipe;
    private List<News> news = new ArrayList<>();
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        swipe = findViewById(R.id.act_third_swipe);
        recyclerView = findViewById(R.id.act_third_recyclerview);
        // 指定一个默认的布局管理器
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        // 指定item插入/移除动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // 指定item分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        // 指定适配器
        News n1 = new News(1, "阿根廷VS波黑", "小组赛F组 阿根廷VS波黑");
        news.add(n1);
        adapter = new ThirdAdapter(news);

        recyclerView.setAdapter(adapter);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //模拟耗时操作，子线程禁止直接修改主线程控件属性
                new Handler().postDelayed(() -> {
                    //取消刷新动画
                    swipe.setRefreshing(false);
                    news.add(0, new News(1, "阿根廷VS波黑" + news.size(), "小组赛F组 阿根廷VS波黑"));
                    adapter.notifyDataSetChanged();
                }, 2000);
            }
        });
    }
}
