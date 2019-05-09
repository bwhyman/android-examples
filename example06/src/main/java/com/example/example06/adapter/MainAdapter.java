package com.example.example06.adapter;

import android.util.Log;
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

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private static final String TAG = "MainAdapter";
    private List<News> news;

    public MainAdapter(List<News> news) {
        this.news = news;
    }

    /**
     * 基于指定样式，渲染item，并将item对象绑定到viewholder
     * 当回收缓存区没有vm时，回调
     * 基于布局创建item对象，创建vm封装item对象，返回vm以复用
     * 因此，仅会回调有限次数。不同系统版本，不同屏幕尺寸等等均不同
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder");
        // 每一个item对象
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_news, parent, false);
        // 由VM持有
        return new MyViewHolder(itemView);
    }

    /**
     * 当渲染指定位置item时，从回收缓存区注入一个相同布局类型的vm，以及item的位置
     * 从vm中获取持有的控件对象，将指定集合位置的数据加载到控件，渲染
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: " + position + "/" + news.get(position).title);
        holder.title.setText(news.get(position).title);
        holder.suttitle.setText(news.get(position).subtitle);
        // 模拟图片
        holder.pic.setImageResource(R.mipmap.ic_launcher);
    }

    // 必须指定初始化时item数量，后期可动态改变
    @Override
    public int getItemCount() {
        return news.size();
    }

    /**
     * VM的作用是保持item view上的控件对象的引用
     * 避免在复用item上反复findViewById
     */
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
