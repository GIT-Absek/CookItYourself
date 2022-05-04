package com.example.cookityourself;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Northindian extends AppCompatActivity {

    TextView title,pp,mp;
    ConstraintLayout dish1,dish2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northindian);

        pp = (TextView)findViewById(R.id.pp);
        mp = (TextView)findViewById(R.id.mp);
        dish1 = (ConstraintLayout)findViewById(R.id.dish1);
        dish2 = (ConstraintLayout)findViewById(R.id.dish2);

        Intent i = getIntent();
        String s_title = i.getSerializableExtra("title").toString();
        title = (TextView)findViewById(R.id.title);
        title.setText(s_title);

        dish1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Northindian.this,Palakpaneer.class);
                intent.putExtra("title",pp.getText().toString());
                startActivity(intent);
            }
        });
        dish2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Northindian.this,Matarpaneer.class);
                intent.putExtra("title",mp.getText().toString());
                startActivity(intent);
            }
        });

    }
}