package com.example.example14;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.example14.databinding.ActivityInsertCourseBinding;
import com.example.example14.viewmodel.InsertCourseViewModel;
import com.google.android.material.snackbar.Snackbar;

public class InsertCourseActivity extends AppCompatActivity {
    private InsertCourseViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = ViewModelProviders.of(this).get(InsertCourseViewModel.class);
        ActivityInsertCourseBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_insert_course);
        binding.setInsertVM(vm);
        binding.setLifecycleOwner(this);
    }

    public void insert(View view) {
        // 调用VM方法实现添加
        vm.insert();

        /**
         * Snackbar,需引入material依赖；
         * Toast，浮动显示，即使activity等已退出依然显示
         * snackbar，需要一个view对象，在当前视图显示；
         * 支持像Toast显示short/long时间自动收回
         * 支持定义互交操作
         */
        Snackbar.make(view, "课程添加成功", Snackbar.LENGTH_INDEFINITE)
                .setAction("确定", v -> {
                    finish();
                }).show();
    }
}
