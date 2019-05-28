package com.example.example14.repository;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.example14.entity.Course;
import com.example.example14.util.MyApplication;

/**
 * 自动在data/data/应用包/下，创建databases目录
 */
@Database(entities = {Course.class}, version = 1, exportSchema = false)
public abstract class DatabaseFactory extends RoomDatabase {
    /**
     * 声明的是抽查类，以及抽象方法，而不是接口！～
     * android自动实现抽象方法，并动态生成接口代理类
     * @return
     */
    public abstract CourseDao courseDao();

    /**
     * 基于全局context，数据库配置类(就是此类)，数据库名称，构建数据库工厂
     */
    private static DatabaseFactory dataBaseFactory = Room
            .databaseBuilder(MyApplication.getInstance(), DatabaseFactory.class, "database")
            // 默认SQLite数据库查询操作在子线程异步执行，添加/修改/删除在主线程，可强制全部使用主线程
            .allowMainThreadQueries()
            .build();

    /**
     * 仅对外暴露自动创建的接口代理对象
     * @return
     */
    public static CourseDao getCourseDao() {
        return dataBaseFactory.courseDao();
    }
}
