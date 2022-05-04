package com.example.cookityourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class searchedDish extends AppCompatActivity {

    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searched_dish);
        Intent i = getIntent();
        String s_title = i.getSerializableExtra("title").toString();
        title = (TextView)findViewById(R.id.title);
        title.setText("Results for "+s_title);
    }
}