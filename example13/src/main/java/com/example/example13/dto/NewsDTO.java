package com.example.example13.dto;

import com.example.example13.entity.News;

import java.util.List;

/**
 * 属性名称必须与响应中属性名称完全相同，一个dto可对应多个响应
 * 没有对应属性，自动忽略
 */
public class NewsDTO {
    public News news;
    public List<News> newsList;

}
