package com.example.cookityourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView categories,bguide,login,signup;
    ImageSlider is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categories = (TextView)findViewById(R.id.categories);
        bguide = (TextView)findViewById(R.id.bguide);
        signup = (TextView)findViewById(R.id.signup);
        login = (TextView)findViewById(R.id.login);
        is = (ImageSlider)findViewById(R.id.imageslider);

        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel(R.drawable.cslider1,null));
        images.add(new SlideModel(R.drawable.cslider2,null));
        images.add(new SlideModel(R.drawable.cslider3,null));

        is.setImageList(images);

        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Categories.class);
                intent.putExtra("title",categories.getText().toString());
                startActivity(intent);
            }
        });

        bguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Bguide.class);
                intent.putExtra("title",bguide.getText().toString());
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Signup.class);
                intent.putExtra("title",signup.getText().toString());
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Login.class);
                intent.putExtra("title",login.getText().toString());
                startActivity(intent);
            }
        });
    }
}