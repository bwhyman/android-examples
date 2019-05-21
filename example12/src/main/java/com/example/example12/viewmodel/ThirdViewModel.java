package com.example.example12.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ThirdViewModel extends AndroidViewModel {
    private static final String TAG = "ThirdViewModel";
    public MutableLiveData<Boolean> checked = new MutableLiveData<>();
    public MutableLiveData<String> userName = new MutableLiveData<>();

    public ThirdViewModel(@NonNull Application application) {
        super(application);
        userName.setValue("BO");
    }

    public void change() {
        userName.setValue("BO");
    }
}
