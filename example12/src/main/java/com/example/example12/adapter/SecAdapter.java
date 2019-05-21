package com.example.example12.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.example12.R;
import com.example.example12.databinding.RecyclerviewNewsBinding;
import com.example.example12.entity.News;

import java.util.ArrayList;
import java.util.List;

public class SecAdapter extends RecyclerView.Adapter<SecAdapter.MyViewHolder>{
    private static final String TAG = "SecAdapter";
    //  当前需渲染的数据集合
    // 初始化adapter时，模拟没有数据
    private List<News> currentNewsList = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // 为每个item创建binding对象，复用
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

    /**
     * viewholder不再holder控件，而是每一个itemview对应的binding对象
     * 通过binding对象绑定集合中的数据
     */
    static class MyViewHolder extends RecyclerView.ViewHolder {
        private RecyclerviewNewsBinding binding;

        public MyViewHolder(@NonNull View itemView, RecyclerviewNewsBinding binding) {
            super(itemView);
            this.binding = binding;
        }
    }

    /**
     * 传入新数据，整合原数据，基于自定义的Callback，更新adapter
     * @param newNewsList
     */
    public void updateNews(List<News> newNewsList) {
        // 需渲染全部数据，而非新加载的数据，因此创建集合添加全部数据
        List<News> allNewsList = new ArrayList<>();
        // 加入原数据
        allNewsList.addAll(getCurrentNewsList());
        // 在顶部加入新数据
        allNewsList.addAll(0, newNewsList);
        // 创建自动计算的效率更高的diff对象
        DiffUtil.DiffResult diff = DiffUtil.calculateDiff(new MyDiffCallback(allNewsList, currentNewsList));
        // 通知adpter基于新数据更新
        diff.dispatchUpdatesTo(this);
        // 必须手动更新封装的数据即可，dispatchUpdatesTo
        setCurrentNewsList(allNewsList);
    }

    /**
     * DiffUtil/Callback支持自动计算最佳更新方法，封装调用支持动画效果的dapter更新方法
     */
    static class MyDiffCallback extends DiffUtil.Callback {
        private List<News> nNews;
        private List<News> oNews;

        public MyDiffCallback(List<News> nNews, List<News> oNews) {
            this.nNews = nNews;
            this.oNews = oNews;
        }

        @Override
        public int getOldListSize() {
            return oNews.size();
        }

        @Override
        public int getNewListSize() {
            return nNews.size();
        }

       // 自定义如何判断2个item是否相同
        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            Log.i(TAG, "" + oldItemPosition + "/" + newItemPosition);
            return oNews.get(oldItemPosition).id == nNews.get(newItemPosition).id;
        }

       // 自定义判断2特item内容是否相同，即内容是否更新
        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return oNews.get(oldItemPosition).title == nNews.get(newItemPosition).title;
        }
    }

    public List<News> getCurrentNewsList() {
        return currentNewsList;
    }

    public void setCurrentNewsList(List<News> currentNewsList) {
        this.currentNewsList = currentNewsList;
    }
}
