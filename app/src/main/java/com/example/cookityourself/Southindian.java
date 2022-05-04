package com.example.cookityourself;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Southindian extends AppCompatActivity {

    TextView title,pd;
    ConstraintLayout dish1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_southindian);

        pd = (TextView)findViewById(R.id.pd);
        dish1 = (ConstraintLayout)findViewById(R.id.dish1);

        Intent i = getIntent();
        String s_title = i.getSerializableExtra("title").toString();
        title = (TextView)findViewById(R.id.title);
        title.setText(s_title);

        dish1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Southindian.this,Plaindosa.class);
                intent.putExtra("title",pd.getText().toString());
                startActivity(intent);
            }
        });
    }
}