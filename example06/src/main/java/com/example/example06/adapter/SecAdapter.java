package com.example.example06.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.example06.R;
import com.example.example06.entity.News;

import java.util.List;

public class SecAdapter extends RecyclerView.Adapter<SecAdapter.ViewHolder> {
    private static final String TAG = "SecAdapter";
    private List<News> news;
    private Context context;

    public SecAdapter(List<News> news, Context context) {
        this.news = news;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_news, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.title.setText(news.get(position).title);
        holder.suttitle.setText(news.get(position).subtitle);
        holder.pic.setImageResource(R.mipmap.ic_launcher);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, news.get(position).title, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return news.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView suttitle;
        public ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            suttitle = itemView.findViewById(R.id.news_subtitle);
            pic = itemView.findViewById(R.id.news_pic);
        }
    }

    // 自定义监听接口
    public interface OnItemClickListener {
        void onItemClick(View view, int position, News news);
    }
}
