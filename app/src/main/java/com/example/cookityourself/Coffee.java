package com.example.cookityourself;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Coffee extends AppCompatActivity {

    TextView title,cc;
    ConstraintLayout dish1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        cc = (TextView)findViewById(R.id.cc);
        dish1 = (ConstraintLayout)findViewById(R.id.dish1);

        Intent i = getIntent();
        String s_title = i.getSerializableExtra("title").toString();
        title = (TextView)findViewById(R.id.title);
        title.setText(s_title);

        dish1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Coffee.this,Coldcoffee.class);
                intent.putExtra("title",cc.getText().toString());
                startActivity(intent);
            }
        });
    }
}