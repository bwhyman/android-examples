package com.example.example03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUserName;
    private Button buttonSubmit;
    private TextView textViewUserName;
    private EditText editTextNameChange;
    private TextView textViewNamechange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserName = findViewById(R.id.act_main_editText_username);
        buttonSubmit = findViewById(R.id.act_main_button_submit);
        textViewUserName = findViewById(R.id.act_main_textView_username);
        editTextNameChange  =findViewById(R.id.act_main_editText_change);
        textViewNamechange = findViewById(R.id.act_main_textView_change);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = editTextUserName.getText().toString();
                textViewUserName.setText(string);
            }
        });


        editTextNameChange.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textViewNamechange.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
