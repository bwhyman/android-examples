package com.example.example13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.example13.adapter.SecRecyclerAdapter;
import com.example.example13.databinding.ActivitySecBinding;
import com.example.example13.viewmodel.SecViewModel;

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
        binding.setVm(viewModel);
        binding.setLifecycleOwner(this);

        SecRecyclerAdapter adapter = new SecRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        // 监听MV中数据更新，注入结果
        viewModel.newsList.observe(this, news -> {
            // 将最新数据交由adapter渲染
            adapter.setCurrentNewsList(news);
            adapter.notifyDataSetChanged();
            // 更新到顶部
            recyclerView.scrollToPosition(0);
        });

        binding.actSecButton.setOnClickListener(v -> {
            Intent i = new Intent(SecActivity.this, ThirdActivity.class);
            startActivity(i);
        });
    }

    private void initRecyclerView() {
        // 基于ID名称直接获取绑定视图上的组件，无需findviewbyid()方法
        recyclerView = binding.actSecRecylerview;
        // 指定一个默认的布局管理器
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.loadNews();
    }
}
