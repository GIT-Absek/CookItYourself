package com.example.cookityourself;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Others extends AppCompatActivity {

    TextView title,ags,pb,gcpz;
    ConstraintLayout dish1,dish2,dish3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);

        ags = (TextView)findViewById(R.id.imageView1text);
        pb = (TextView)findViewById(R.id.pb);
        gcpz = (TextView)findViewById(R.id.gcpz);
        dish1 = (ConstraintLayout)findViewById(R.id.dish1);
        dish2 = (ConstraintLayout)findViewById(R.id.dish2);
        dish3 = (ConstraintLayout)findViewById(R.id.dish3);

        Intent i = getIntent();
        String s_title = i.getSerializableExtra("title").toString();
        title = (TextView)findViewById(R.id.title);
        title.setText(s_title);

        dish1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Others.this,Aalogrilledsandwich.class);
                intent.putExtra("title",ags.getText().toString());
                startActivity(intent);
            }
        });
        dish1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Others.this,Aalogrilledsandwich.class);
                intent.putExtra("title",ags.getText().toString());
                startActivity(intent);
            }
        });
        dish2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Others.this,Paneerburger.class);
                intent.putExtra("title",pb.getText().toString());
                startActivity(intent);
            }
        });
        dish3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Others.this,Goldencornpizza.class);
                intent.putExtra("title",gcpz.getText().toString());
                startActivity(intent);
            }
        });
    }
}