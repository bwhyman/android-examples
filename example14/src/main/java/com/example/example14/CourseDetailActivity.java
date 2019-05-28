package com.example.example14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.example14.databinding.ActivityCourseDetailBinding;
import com.example.example14.viewmodel.CourseDetailViewModel;

public class CourseDetailActivity extends AppCompatActivity {

    /**
     * 如果是单activity切换fragment，就不用这么麻烦了
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCourseDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_course_detail);
        CourseDetailViewModel vm = ViewModelProviders.of(this).get(CourseDetailViewModel.class);
        binding.setVm(vm);
        binding.setLifecycleOwner(this);
        vm.getCourse(getIntent().getIntExtra("id", 0));
    }
}
