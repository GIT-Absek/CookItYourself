package com.example.cookityourself;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Burger extends AppCompatActivity {

    TextView title,pb;
    ConstraintLayout dish1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);

        pb = (TextView)findViewById(R.id.pb);
        dish1 = (ConstraintLayout)findViewById(R.id.dish1);

        Intent i = getIntent();
        String s_title = i.getSerializableExtra("title").toString();
        title = (TextView)findViewById(R.id.title);
        title.setText(s_title);

        dish1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Burger.this,Paneerburger.class);
                intent.putExtra("title",pb.getText().toString());
                startActivity(intent);
            }
        });
    }
}