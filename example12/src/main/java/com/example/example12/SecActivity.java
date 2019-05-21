package com.example.example12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.example12.adapter.SecAdapter;
import com.example.example12.databinding.ActivitySecBinding;
import com.example.example12.entity.News;
import com.example.example12.viewmodel.SecViewModel;

import java.util.ArrayList;
import java.util.List;

public class SecActivity extends AppCompatActivity {
    private static final String TAG = "SecActivity";
    private RecyclerView recyclerView;
    private ActivitySecBinding binding;
    private SecViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sec);
        // 提出recycle初始化代码
        initRecyclerView();
        // 构造VM，
        viewModel = ViewModelProviders.of(this).get(SecViewModel.class);
        binding.setSecVM(viewModel);
        binding.setLifecycleOwner(this);

        SecAdapter adapter = new SecAdapter();
        recyclerView.setAdapter(adapter);
        // 监听MV中数据更新，注入结果
        viewModel.newsLoad.observe(this, news -> {
                Log.i(TAG, "onChanged");
                // 将最新数据交由adapter渲染
                adapter.updateNews(news);
                // 更新到顶部
                recyclerView.scrollToPosition(0);
        });
    }

    private void initRecyclerView() {
        // 基于ID名称直接获取绑定视图上的组件，无需findviewbyid()方法
        recyclerView = binding.actSecRecyclerview;
        // 指定一个默认的布局管理器
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }

    public void toThird(View v) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}
