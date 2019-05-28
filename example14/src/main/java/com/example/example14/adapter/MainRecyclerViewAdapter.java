package com.example.example14.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.example14.CourseDetailActivity;
import com.example.example14.R;
import com.example.example14.databinding.RecyclerviewMainBinding;
import com.example.example14.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MyViewHolder> {

    private Context context;

    public MainRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    private List<Course> courseList = new ArrayList<>();
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater l = LayoutInflater.from(parent.getContext());
        RecyclerviewMainBinding binding = DataBindingUtil.inflate(l, R.layout.recyclerview_main, parent, false);
        return new MyViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.setCourse(courseList.get(position));
        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, CourseDetailActivity.class);
            i.putExtra("id", courseList.get(position).id);
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        RecyclerviewMainBinding binding;
        public MyViewHolder(@NonNull View itemView, RecyclerviewMainBinding binding) {
            super(itemView);
            this.binding = binding;
        }
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

}
