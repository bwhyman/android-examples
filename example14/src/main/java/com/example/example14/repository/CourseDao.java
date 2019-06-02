package com.example.example14.repository;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RoomWarnings;
import androidx.room.Transaction;

import com.example.example14.entity.Course;

import java.util.List;

@Dao
public interface CourseDao {
    @Query("SELECT * FROM Course")
    List<Course> list();

    @Query("SELECT * FROM Course c WHERE c.id=:id")
    Course find(int id);

    /**
     * 支持指定的封装属性，而非全部属性
     * @return
     */
    @Query("SELECT c.id, c.name FROM Course c")
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    List<Course> listName();

    @Insert
    @Transaction
    void insert(Course... course);
}
