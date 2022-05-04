package com.example.cookityourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    TextView categories,bguide,logout,logintext;
    ImageSlider is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        categories = (TextView)findViewById(R.id.categories);
        bguide = (TextView)findViewById(R.id.bguide);
        logout = (TextView)findViewById(R.id.logout);
        logintext = (TextView)findViewById(R.id.logintext);
        is = (ImageSlider)findViewById(R.id.imageslider);

        logintext.setText("Logged in as "+getIntent().getSerializableExtra("uname").toString());

        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel(R.drawable.cslider1,null));
        images.add(new SlideModel(R.drawable.cslider2,null));
        images.add(new SlideModel(R.drawable.cslider3,null));

        is.setImageList(images);

        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,Categories.class);
                intent.putExtra("title",categories.getText().toString());
                startActivity(intent);
            }
        });

        bguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,Bguide.class);
                intent.putExtra("title",bguide.getText().toString());
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(MainActivity2.this, "Logout Successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}