package com.example.example06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.example06.adapter.MainAdapter;
import com.example.example06.entity.News;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.act_main_recyclerview);
        // 指定一个默认的布局管理器
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        // 指定item插入/移除动画
        // recyclerView.setItemAnimator(new DefaultItemAnimator());
        // 指定item分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        // 指定适配器
        adapter = new MainAdapter(listNews());
        recyclerView.setAdapter(adapter);

        button = findViewById(R.id.act_main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<News> listNews() {
        News n1 = new News(1, "阿根廷VS波黑", "小组赛F组 阿根廷VS波黑");
        News n2 = new News(2, "法国VS洪都拉斯", "小组赛E组 法国VS洪都拉斯");
        News n3 = new News(3, "瑞士VS厄瓜多尔", "小组赛E组 瑞士VS厄瓜多尔");
        News n4 = new News(4, "西班牙VS荷兰", "小组赛B组 西班牙VS荷兰");
        News n5 = new News(5, "俄罗斯VS丹麦", "小组赛A组 俄罗斯VS丹麦");
        News n6 = new News(6, "巴西VS意大利", "小组赛C组 巴西VS意大利");
        News n7 = new News(7, "日本VS伊朗", "小组赛D组 日本VS伊朗");
        List<News> news = new ArrayList<>();
        news.add(n1); news.add(n2); news.add(n3); news.add(n4);
        news.add(n5); news.add(n6); news.add(n7);
        news.add(n1); news.add(n2); news.add(n3); news.add(n4);
        return news;
    }
}
