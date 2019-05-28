package com.example.example14.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.example14.entity.Course;
import com.example.example14.repository.DatabaseFactory;

public class CourseDetailViewModel extends AndroidViewModel {
    public MutableLiveData<Course> courseM = new MutableLiveData<>();
    public CourseDetailViewModel(@NonNull Application application) {
        super(application);
        courseM.setValue(new Course());
    }

    public void getCourse(int id) {
        Course c = DatabaseFactory.getCourseDao().find(id);
        courseM.setValue(c);
    }

}
