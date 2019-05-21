package com.example.example12.entity;

import androidx.databinding.BaseObservable;

import java.util.Observable;

public class News {
    public int id;
    public String picAdress;
    public String title;
    public String subtitle;

    public News(int id, String title, String subtitle) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
    }
}
