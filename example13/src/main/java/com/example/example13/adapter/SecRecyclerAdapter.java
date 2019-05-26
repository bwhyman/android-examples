package com.example.example13.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.example13.R;
import com.example.example13.databinding.RecyclerviewNewsBinding;
import com.example.example13.entity.News;

import java.util.ArrayList;
import java.util.List;

public class SecRecyclerAdapter extends RecyclerView.Adapter<SecRecyclerAdapter.MyViewHolder> {

    private List<News> currentNewsList = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerviewNewsBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recyclerview_news, parent, false);
        return new MyViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.setNews(currentNewsList.get(position));
    }

    @Override
    public int getItemCount() {
        return currentNewsList.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerviewNewsBinding binding;
        public MyViewHolder(@NonNull View itemView, RecyclerviewNewsBinding binding) {
            super(itemView);
            this.binding = binding;
        }
    }
    public List<News> getCurrentNewsList() {
        return currentNewsList;
    }

    public void setCurrentNewsList(List<News> currentNewsList) {
        this.currentNewsList = currentNewsList;
    }

}
