package com.example.example12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.example12.databinding.ActivityMainBinding;
import com.example.example12.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 取消默认调用setContentView()方法代码

        /**
         * 必须先在layout中使用data标签声明变量
         * 才能基于layout文件的命名，动态自动生成ActivityMainBinding类
         */
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // 必须通过工具类获取VM对象，不能手动创建
        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // 基于layout中声明的变量，自动生成属性变量的getter/setter方法
        binding.setMianVM(mainViewModel);
        /**
         * 将绑定数据，与当前activity生命周期绑定
         * 例如，当数据改变时，且activity可见时，自动更新页面
         */
        binding.setLifecycleOwner(this);
    }
    /**
     * 有activity处理UI，跳转更新等操作，业务逻辑操作由vm负责
     * @param view
     */
    public void onButtonClick(View view) {
        Log.i(TAG, "onButtonClick: ");
        Intent intent = new Intent(this, SecActivity.class);
        startActivity(intent);
    }
}
