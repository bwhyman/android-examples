package com.example.example14.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.example14.entity.Course;
import com.example.example14.repository.DatabaseFactory;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private static final String TAG = "MainViewModel";
    public MutableLiveData<List<Course>> coursesM = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadFromRoom() {
        List<Course> courses = DatabaseFactory.getCourseDao().listName();
        coursesM.setValue(courses);
    }
}
