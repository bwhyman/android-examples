package com.example.example05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecActivity extends AppCompatActivity {
    private static final String TAG = "SecActivity";

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        Log.i(TAG, "SecActivity onCreate()");
        String value = getIntent().getStringExtra("value");
        textView = findViewById(R.id.act_sec_textview);
        textView.setText(value);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "SecActivity onStart()");
        // The activity is about to become visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "SecActivity onResume()");
        // The activity has become visible (it is now "resumed").
    }
    @Override
    protected void onPause() {
        Log.i(TAG, "SecActivity onPause()");
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }
    @Override
    protected void onStop() {
        Log.i(TAG, "SecActivity onStop()");
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }
    @Override
    protected void onDestroy() {
        Log.i(TAG, "SecActivity onDestroy()");
        super.onDestroy();
        // The activity is about to be destroyed.
    }

}
