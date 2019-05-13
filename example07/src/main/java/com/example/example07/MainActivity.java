package com.example.example07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.example07.adapter.MainAdapter;
import com.example.example07.adapter.MyCallback;
import com.example.example07.entity.News;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private SwipeRefreshLayout swipe;
    private List<News> news = listNews();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.act_main_recyclerview);
        // 指定一个默认的布局管理器
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        // 指定item插入/移除动画
        DefaultItemAnimator animator = new DefaultItemAnimator();
        // 包含默认的操作动画世界，也可自定义动画时间
        animator.setRemoveDuration(500);
        animator.setMoveDuration(500);
        recyclerView.setItemAnimator(animator);
        // 指定item分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        // 指定适配器
        adapter = new MainAdapter(news);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper helper = new ItemTouchHelper(new MyCallback(adapter));
        helper.attachToRecyclerView(recyclerView);

        swipe = findViewById(R.id.act_third_swipe);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //模拟耗时操作，子线程禁止直接修改主线程控件属性
                new Handler().postDelayed(() -> {
                    //取消刷新动画
                    swipe.setRefreshing(false);
                    news.add(0, new News(1, "阿根廷VS波黑" + news.size(), "小组赛F组 阿根廷VS波黑"));
                    // 指定通知可提高渲染效率，同时支持动画
                    adapter.notifyItemInserted(0);
                    recyclerView.scrollToPosition(0);
                }, 500);
            }
        });
    }

    private List<News> listNews() {
        List<News> news = new ArrayList<>();
        News n1 = new News(1, "阿根廷VS波黑", "小组赛F组 阿根廷VS波黑");
        News n2 = new News(2, "法国VS洪都拉斯", "小组赛E组 法国VS洪都拉斯");
        News n3 = new News(3, "瑞士VS厄瓜多尔", "小组赛E组 瑞士VS厄瓜多尔");
        news.add(n1); news.add(n2); news.add(n3);
        return news;
    }
}

