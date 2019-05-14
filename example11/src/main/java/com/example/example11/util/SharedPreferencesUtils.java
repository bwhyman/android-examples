package com.example.example11.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 有则直接使用，没有则创建名为为pre_my的XML配置文件
 * 位置data\data\packagename\shared_prefs
 * 声明使用范围
 */
public class SharedPreferencesUtils {
    private static SharedPreferences sf = create();
    private static final String PRE_FILE = "pre_my";
    private static final String MYEDIT = "myedit";

    /**
     * 封装SharedPreferences的构建过程，对外仅暴露允许修改的方法
     * @return
     */
    private static SharedPreferences create() {
        return MyApplication.getInstance()
                .getSharedPreferences(PRE_FILE, Context.MODE_PRIVATE);
    }

    public static void putMyedit (String myedit) {
        sf.edit().putString(MYEDIT, myedit).apply();
    }

    public static String getMyedit() {
        return sf.getString(MYEDIT, "");
    }

}
