package com.example.example13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.example13.dto.NewsDTO;
import com.example.example13.entity.News;
import com.example.example13.service.ServiceFactory;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThirdActivity extends AppCompatActivity {
    private static final String TAG = "ThirdActivity";
    private EditText title;
    private EditText subtitle;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);
        title = findViewById(R.id.act_third_edittext_title);
        subtitle = findViewById(R.id.act_third_edittext_subtitle);
        findViewById(R.id.act_third_button).setOnClickListener(v -> {
            News n = new News();
            n.title = "" + title.getText().toString();
            n.subtitle = "" + subtitle.getText().toString();
            // 不能仅执行post()方法，必须执行enqueue()方法添加至执行队列
            ServiceFactory.getNewsService().post(n).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    //  结束此activity
                    finish();
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                }
            });
        });
    }
}
