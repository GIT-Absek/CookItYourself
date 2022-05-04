package com.example.cookityourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Resetpassword2 extends AppCompatActivity {

    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword2);

        title=(TextView)findViewById(R.id.title);

        Intent i = getIntent();
        String s_title = i.getSerializableExtra("title").toString();
        title.setText(s_title);
    }
}