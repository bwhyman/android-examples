package com.example.example06.entity;

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
