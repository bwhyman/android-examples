package com.example.example14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.example14.adapter.MainRecyclerViewAdapter;
import com.example.example14.databinding.ActivityMainBinding;
import com.example.example14.entity.Course;
import com.example.example14.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private MainViewModel vm;
    private ActivityMainBinding binding;
    private MainRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = ViewModelProviders.of(this).get(MainViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVm(vm);
        binding.setLifecycleOwner(this);
        initRecyclerView();
        adapter = new MainRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
        vm.coursesM.observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(List<Course> courses) {
                adapter.setCourseList(courses);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initRecyclerView() {
        // 基于ID名称直接获取绑定视图上的组件，无需findviewbyid()方法
        recyclerView = binding.actMainRecyclerview;
        // 指定一个默认的布局管理器
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }

    public void toInsert(View view) {
        Intent i = new Intent(this, InsertCourseActivity.class);
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        vm.loadFromRoom();
    }
}
