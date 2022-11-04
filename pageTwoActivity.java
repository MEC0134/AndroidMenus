package com.example.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class pageTwoActivity extends AppCompatActivity {

    TextView txtVw;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);

        txtVw = findViewById(R.id.txtVwActTwo);


        Intent intent = getIntent();

        String firstName = intent.getStringExtra("fName");
        String userName = intent.getStringExtra("lName");


        txtVw.setText(firstName + " " + userName);



    }
}