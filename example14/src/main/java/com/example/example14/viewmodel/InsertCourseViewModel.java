package com.example.example14.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.example14.entity.Course;
import com.example.example14.repository.DatabaseFactory;

public class InsertCourseViewModel extends AndroidViewModel {
    public MutableLiveData<Course> courseM = new MutableLiveData<>();
    public InsertCourseViewModel(@NonNull Application application) {
        super(application);
        courseM.setValue(new Course());
    }

    public void insert() {
        DatabaseFactory.getCourseDao().insert(courseM.getValue());
    }
}
