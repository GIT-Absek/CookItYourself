package com.example.cookityourself;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Bguide extends AppCompatActivity {

    TextView title;
    ConstraintLayout c1,c2,c3,c4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bguide);
        Intent i = getIntent();
        String s_title = i.getSerializableExtra("title").toString();
        title = (TextView) findViewById(R.id.title);
        title.setText(s_title);
        Toast.makeText(Bguide.this, "Click on the text for more information", Toast.LENGTH_LONG).show();

        c1 = (ConstraintLayout) findViewById(R.id.bguide1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bguide.this,Bguide1.class);
                i.putExtra("title","How to read and pick a recipe?");
                startActivity(i);
            }
        });

        c2 = (ConstraintLayout) findViewById(R.id.bguide2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bguide.this,Bguide2.class);
                i.putExtra("title","How to cook?");
                startActivity(i);
            }
        });
        c3 = (ConstraintLayout) findViewById(R.id.bguide3);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bguide.this,Bguide3.class);
                i.putExtra("title","Assemble your tools and stock your pantry.");
                startActivity(i);
            }
        });
        c4 = (ConstraintLayout) findViewById(R.id.bguide4);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bguide.this,Bguide4.class);
                i.putExtra("title","Cook safely!");
                startActivity(i);
            }
        });
    }
}