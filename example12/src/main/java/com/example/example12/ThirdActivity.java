package com.example.example12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.example12.databinding.ActivityThirdBinding;
import com.example.example12.viewmodel.ThirdViewModel;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThirdBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_third);
        ThirdViewModel vm = ViewModelProviders.of(this).get(ThirdViewModel.class);
        binding.setThirdVM(vm);
        binding.setLifecycleOwner(this);

    }
}
