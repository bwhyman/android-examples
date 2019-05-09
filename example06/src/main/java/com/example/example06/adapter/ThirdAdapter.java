package com.example.example06.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.example06.R;
import com.example.example06.entity.News;

import java.util.List;

public class ThirdAdapter extends RecyclerView.Adapter<ThirdAdapter.MyViewHolder> {
    private static final String TAG = "ThirdAdapter";
    private List<News> news;

    public ThirdAdapter(List<News> news) {
        this.news = news;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_news, parent, false);
        MyViewHolder vm = new MyViewHolder(itemView);
        return vm;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(news.get(position).title);
        holder.suttitle.setText(news.get(position).subtitle);
        holder.pic.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView suttitle;
        ImageView pic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            suttitle = itemView.findViewById(R.id.news_subtitle);
            pic = itemView.findViewById(R.id.news_pic);
        }
    }
}
